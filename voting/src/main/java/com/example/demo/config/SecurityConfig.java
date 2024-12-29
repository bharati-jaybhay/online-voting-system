package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Define which URLs are accessible
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").hasRole("USER") // Only users with "USER" role can access "/user/**"
                        .requestMatchers("/**").permitAll() // Allow everyone to access all other URLs
                )
                // Disable CSRF protection (new recommended way)
                .csrf(csrf -> csrf.disable());

        return http.build(); // Build the security filter chain
    }
}

