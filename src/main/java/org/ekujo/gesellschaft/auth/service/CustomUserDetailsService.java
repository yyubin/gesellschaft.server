package org.ekujo.gesellschaft.auth.service;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.auth.exception.AuthErrorCode;
import org.ekujo.gesellschaft.auth.exception.AuthException;
import org.ekujo.gesellschaft.user.domain.CustomUserDetails;
import org.ekujo.gesellschaft.user.domain.User;
import org.ekujo.gesellschaft.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new AuthException(AuthErrorCode.USERNAME_NOT_FOUND));
    }
}