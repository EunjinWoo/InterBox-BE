package com.interbox.interbox_be.domain.user.service;

import com.interbox.interbox_be.domain.user.entity.User;
import com.interbox.interbox_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser() {
        User user = User.builder().build();
        return userRepository.save(user);
    }
}
