package br.com.letscode.todolist.filter;

import br.com.letscode.todolist.config.UserContext;
import br.com.letscode.todolist.exception.AccessDeniedException;
import br.com.letscode.todolist.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {


    private final JwtUtil jwtTokenUtil;
    private final UserContext userContext;

    @Qualifier("handlerExceptionResolver")
    @Autowired
    private HandlerExceptionResolver resolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        if (StringUtils.isBlank(requestTokenHeader) || !requestTokenHeader.startsWith("Bearer")){
            resolver.resolveException(request, response, null, new AccessDeniedException());
            return;
        }

        final var token = requestTokenHeader.replaceFirst("Bearer ","");
        var userId = jwtTokenUtil.getUserFromToken(token);
        if (StringUtils.isEmpty(userId)){
            resolver.resolveException(request, response, null, new AccessDeniedException());
            return;
        }
        userContext.setUserId(UUID.fromString(userId));
        filterChain.doFilter(request, response);
    }
}
