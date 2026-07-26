package com.avinash.BankingAPI.security;

import com.avinash.BankingAPI.security.jwt.AuthEntryPointJwt;
import com.avinash.BankingAPI.security.jwt.JwtFilter;
import com.avinash.BankingAPI.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public JwtFilter authenticateJwtTokenFilter(){
        return new JwtFilter();
    }
}
