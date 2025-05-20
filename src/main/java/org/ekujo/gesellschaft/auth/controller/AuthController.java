package org.ekujo.gesellschaft.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.auth.dto.request.LoginRequest;
import org.ekujo.gesellschaft.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.ekujo.gesellschaft.auth.response.ResponseMessage.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        HttpStatus respone = authService.login(loginRequest, request);
        if (respone == HttpStatus.OK) {
            return ResponseEntity.ok(LOGIN_SUCCESSFUL);
        }
        return ResponseEntity.status(respone).body(LOGIN_FAILED);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        authService.logout(request);
        return ResponseEntity.ok(LOGOUT_SUCCESSFUL);
    }
}
