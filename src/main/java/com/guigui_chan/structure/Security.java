package com.guigui_chan.structure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration @EnableWebSecurity public class Security {

    private final SecurityFilter MEU_FILTRO;

    public Security (SecurityFilter filtro) { MEU_FILTRO = filtro; }

    @Bean public SecurityFilterChain filtrar (HttpSecurity http) throws Exception {

        return http.csrf(AbstractHttpConfigurer::disable)

        .sessionManagement(sm ->

          sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

        .authorizeHttpRequests(req -> {

            req.requestMatchers(HttpMethod.POST, "/login").permitAll()

        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll();

            req.anyRequest().authenticated(); })

                .addFilterBefore(MEU_FILTRO, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean public AuthenticationManager autentificar (AuthenticationConfiguration config) {

        return config.getAuthenticationManager();
    }

    @Bean public PasswordEncoder embaralhar () {

        return new BCryptPasswordEncoder();
    }
}