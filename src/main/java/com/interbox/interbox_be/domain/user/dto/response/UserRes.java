package com.interbox.interbox_be.domain.user.dto.response;

import com.interbox.interbox_be.domain.job.entity.Job;
import com.interbox.interbox_be.domain.job.enumerate.JobType;
import com.interbox.interbox_be.domain.user.entity.User;
import com.interbox.interbox_be.domain.user.enumerate.Platform;
import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public record UserRes(
        Long id,
        String nickname,
        String email,
        String password,
        Platform platform,
        String profile_image,
        List<Job> jobs
) {
    public static UserRes of(User user) {
        return UserRes.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .platform(user.getPlatform())
                .profile_image(user.getProfile_image())
                .jobs(user.getJobs())
                .build();
    }
}