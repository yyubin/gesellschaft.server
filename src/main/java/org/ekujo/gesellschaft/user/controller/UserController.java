package org.ekujo.gesellschaft.user.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.user.domain.User;
import org.ekujo.gesellschaft.user.dto.response.UserInfoResponse;
import org.ekujo.gesellschaft.user.domain.CustomUserDetails;
import org.ekujo.gesellschaft.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/admin/me")
    public ResponseEntity<?> me(@AuthenticationPrincipal CustomUserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("로그인되어 있지 않습니다.");
        }
        User user = userDetails.getDomainUser();
        return ResponseEntity.ok(UserInfoResponse.builder().id(user.getId()).role(String.valueOf(user.getRole())).username(user.getUsername()).build());
    }

}
