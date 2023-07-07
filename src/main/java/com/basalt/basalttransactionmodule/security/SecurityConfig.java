package com.basalt.basalttransactionmodule.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@Profile("!test")
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    protected static final String[] AUTHORIZED_ENDPOINTS_LIST = {
            // -- swagger ui
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/websocket/**",
    };

    public static String[] getAuthorizedEndpointsList() {
        return Arrays.copyOf(AUTHORIZED_ENDPOINTS_LIST, AUTHORIZED_ENDPOINTS_LIST.length);
    }

    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakGrantedAuthoritiesConverter());
        return jwtConverter;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        @formatter:off
        http
                .csrf()
                .ignoringRequestMatchers(AUTHORIZED_ENDPOINTS_LIST)
                .and()
                .cors()
                .and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AUTHORIZED_ENDPOINTS_LIST).permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter())
                .and();
//        @formatter:on
        return http.build();
    }
}
