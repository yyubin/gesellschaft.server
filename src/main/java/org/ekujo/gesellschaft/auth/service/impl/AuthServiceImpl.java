package org.ekujo.gesellschaft.auth.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.auth.dto.request.LoginRequest;
import org.ekujo.gesellschaft.auth.service.AuthService;
import org.ekujo.gesellschaft.auth.service.CustomUserDetailsService;
import org.ekujo.gesellschaft.user.domain.CustomUserDetails;
import org.ekujo.gesellschaft.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;

    public HttpStatus login(LoginRequest loginRequest, HttpServletRequest httpRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()
        );
        try {
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            httpRequest.getSession(true);
            return HttpStatus.OK;
        } catch (BadCredentialsException e) {
            return HttpStatus.UNAUTHORIZED;
        }
    }

    public void logout(HttpServletRequest request) {
        request.getSession(false).invalidate();
    }

}
