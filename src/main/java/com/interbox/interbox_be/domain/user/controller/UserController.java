package com.interbox.interbox_be.domain.user.controller;

import com.interbox.interbox_be.domain.job.dto.request.JobTypeReq;
import com.interbox.interbox_be.domain.job.dto.response.SelectedJobRes;
import com.interbox.interbox_be.domain.user.dto.request.UserCreateReq;
import com.interbox.interbox_be.domain.user.dto.response.UserRes;
import com.interbox.interbox_be.domain.user.service.UserService;
import com.interbox.interbox_be.global.response.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApplicationResponse<UserRes> createUser(@RequestBody UserCreateReq req) {
        return ApplicationResponse.ok(UserRes.of(userService.createUser(req)));
    }

    @GetMapping("/{userId}")
    public ApplicationResponse<UserRes> getUserWithJobs(
            @PathVariable Long userId
    ) {
        return ApplicationResponse.ok(UserRes.of(userService.getUserWithJobs(userId)));
    }

    @PutMapping("/{userId}/job")
    public ApplicationResponse<UserRes> updateUserJobs(
            @PathVariable Long userId,
            @RequestBody JobTypeReq jobTypeReq
    ) {
        return ApplicationResponse.ok(UserRes.of(userService.updateUserJobs(userId, jobTypeReq.jobTypes())));
    }

}
