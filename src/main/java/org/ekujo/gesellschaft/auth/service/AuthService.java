package org.ekujo.gesellschaft.auth.service;

import jakarta.servlet.http.HttpServletRequest;
import org.ekujo.gesellschaft.auth.dto.request.LoginRequest;
import org.springframework.http.HttpStatus;

public interface AuthService {
    HttpStatus login(LoginRequest loginRequest, HttpServletRequest httpRequest);
    void logout(HttpServletRequest request);
}
