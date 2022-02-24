package br.com.letscode.todolist.filter;

import br.com.letscode.todolist.config.UserContext;
import br.com.letscode.todolist.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {


    private final JwtUtil jwtTokenUtil;
    private final UserContext userContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        /**
         *  - Validar se tem token
         *  - Validar se o token está expirado
         *  - Validar se contem um sub.
         */

        var userId = jwtTokenUtil.getUserFromToken(requestTokenHeader);
        userContext.setUserId(UUID.fromString(userId));
        filterChain.doFilter(request, response);
    }
}
