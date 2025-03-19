package com.interbox.interbox_be.domain.user.dto.request;

import com.interbox.interbox_be.domain.user.enumerate.Platform;
import lombok.Builder;

@Builder
public record UserCreateReq (
        String nickname,
        String email,
        String password,
        Platform platform,
        String profile_image
) {
}
