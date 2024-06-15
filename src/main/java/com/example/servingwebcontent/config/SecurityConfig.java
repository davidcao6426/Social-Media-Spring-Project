package com.example.servingwebcontent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        String[] allowedPaths = { "/", "/user", "/api/**" };
        http
                .csrf(AbstractHttpConfigurer::disable);
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(allowedPaths).permitAll()
//                        .requestMatchers(antMatcher(HttpMethod.POST, "/api/**")).permitAll()
////                        .requestMatchers(antMatcher(HttpMethod.POST, "/api/user/**")).hasRole("USER")//.hasRole("ADMIN")
//                        .anyRequest().permitAll()//authenticated()
//                );
        return http.build();
    }

}
