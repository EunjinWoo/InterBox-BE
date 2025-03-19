package com.interbox.interbox_be.domain.user.controller;

import com.interbox.interbox_be.domain.user.dto.response.UserRes;
import com.interbox.interbox_be.domain.user.service.UserService;
import com.interbox.interbox_be.global.response.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ApplicationResponse<UserRes> createUser() {
        return ApplicationResponse.ok(UserRes.from(userService.createUser()));
    }
}
