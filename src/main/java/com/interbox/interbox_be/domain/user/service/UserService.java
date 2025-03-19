package com.interbox.interbox_be.domain.user.service;

import com.interbox.interbox_be.domain.user.dto.request.UserCreateReq;
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
    public User createUser(UserCreateReq request) {
        User user = User.builder()
                .nickname(request.nickname())
                .email(request.email())
                .password(request.password())
                .platform(request.platform())
                .profile_image(request.profile_image())
                .build();
        return userRepository.save(user);
    }
}
