package org.ekujo.gesellschaft.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.user.repository.UserRepository;
import org.ekujo.gesellschaft.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


}
