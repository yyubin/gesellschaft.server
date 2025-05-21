package org.ekujo.gesellschaft.auth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ekujo.gesellschaft.auth.dto.request.LoginRequest;
import org.ekujo.gesellschaft.auth.dto.response.LoginSuccessResponse;
import org.ekujo.gesellschaft.user.domain.CustomUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors
                        .configurationSource(request -> {
                            CorsConfiguration cfg = new CorsConfiguration();
                            cfg.setAllowedOrigins(List.of("http://localhost:5173"));
                            cfg.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
                            cfg.setAllowedHeaders(List.of("*"));
                            cfg.setAllowCredentials(true);
                            cfg.setExposedHeaders(List.of("Set-Cookie"));
                            return cfg;
                        })
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login", "/api/logout").permitAll()
                        .requestMatchers("/api/admin/**").authenticated()
                        .anyRequest().permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/api/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
                                                       PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authProvider);
    }

//    @Bean
//    public UsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter(
//            AuthenticationManager authenticationManager, ObjectMapper objectMapper) {
//
//        var filter = new UsernamePasswordAuthenticationFilter() {
//            @Override
//            public Authentication attemptAuthentication(
//                    HttpServletRequest request, HttpServletResponse response) {
//
//                if (request.getContentType() != null &&
//                        request.getContentType().startsWith("application/json")) {
//
//                    try (var is = request.getInputStream()) {
//                        var mapper  = new ObjectMapper();
//                        var dto     = mapper.readValue(is, LoginRequest.class);
//                        var token   = new UsernamePasswordAuthenticationToken(
//                                dto.getUsername(), dto.getPassword());
//
//                        setDetails(request, token);
//                        return this.getAuthenticationManager().authenticate(token);
//
//                    } catch (IOException e) {
//                        throw new AuthenticationServiceException(e.getMessage(), e);
//                    }
//                }
//                return super.attemptAuthentication(request, response);
//            }
//        };
//
//        filter.setFilterProcessesUrl("/api/login");
//        filter.setAuthenticationManager(authenticationManager);
//
//        filter.setAuthenticationSuccessHandler((req, res, auth) -> {
//            res.setStatus(HttpServletResponse.SC_OK);
//            res.setContentType("application/json");
//
//            var user = ((CustomUserDetails) auth.getPrincipal()).getDomainUser();
//
//            objectMapper.writeValue(
//                    res.getWriter(),
//                    new LoginSuccessResponse(user.getId(), user.getUsername(), user.getRole().name())
//            );
//        });
//
//        filter.setAuthenticationFailureHandler((req, res, ex) -> {
//            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            res.setContentType("application/json");
//            objectMapper.writeValue(
//                    res.getWriter(),
//                    Map.of("error", ex.getMessage())
//            );
//        });
//
//        return filter;
//    }
}
