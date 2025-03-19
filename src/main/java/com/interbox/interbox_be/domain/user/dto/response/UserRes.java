package com.interbox.interbox_be.domain.user.dto.response;

import com.interbox.interbox_be.domain.user.entity.User;

public record UserRes(Long id) {
    public static UserRes from(User user) {
        return new UserRes(user.getId());
    }
}