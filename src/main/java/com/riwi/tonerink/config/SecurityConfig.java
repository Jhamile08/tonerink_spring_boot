package com.riwi.tonerink.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.riwi.tonerink.infrastructure.helpers.JwtFilter;
import com.riwi.tonerink.util.enums.Role;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    @Autowired
    private final AuthenticationProvider authenticationProvider;
    @Autowired
    private final JwtFilter jwtAuthFilter;

    // Crear rutas públicas
    private final String[] PUBLIC_RESOURCES = { "/test/public/get", "product/get/{id}","product/get","/auth/**" };
    private final String ADMIN_RESOURCE = "/product/add";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Deshabilitar protección CSRF -> Stateless
                .authorizeHttpRequests(authRequest -> authRequest
                    .requestMatchers(PUBLIC_RESOURCES).permitAll() // Configurar rutas públicas
                    .requestMatchers(ADMIN_RESOURCE).hasRole(Role.ADMIN.name())
                    .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager ->
                    sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(this.authenticationProvider)
                // Agregar el filtro de JWT antes del filtro de autenticación de username y password
                .addFilterBefore(this.jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
