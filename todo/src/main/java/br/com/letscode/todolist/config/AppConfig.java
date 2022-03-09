package br.com.letscode.todolist.config;

import br.com.letscode.todolist.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Autowired
    private JwtRequestFilter filter;

    @Bean
    public FilterRegistrationBean<JwtRequestFilter> filterRegistrationBean() {
        FilterRegistrationBean<JwtRequestFilter> registrationBean = new FilterRegistrationBean<JwtRequestFilter>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }



}