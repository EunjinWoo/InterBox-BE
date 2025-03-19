package com.interbox.interbox_be.domain.user.dto.response;

import com.interbox.interbox_be.domain.user.entity.User;
import com.interbox.interbox_be.domain.user.enumerate.Platform;
import lombok.Builder;

@Builder
public record UserRes(
        Long id,
        String nickname,
        String email,
        String password,
        Platform platform,
        String profile_image
) {
    public static UserRes of(User user) {
        return UserRes.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .platform(user.getPlatform())
                .profile_image(user.getProfile_image())
                .build();
    }
}