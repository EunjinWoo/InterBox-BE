package com.interbox.interbox_be.domain.user.entity;

import com.interbox.interbox_be.domain.user.enumerate.Platform;
import com.interbox.interbox_be.global.common.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Getter
@Entity
@SQLDelete(sql = "UPDATE user SET deleted_at = NOW() where user_id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String nickname;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(nullable = false, columnDefinition = "TEXT")
    private Platform platform;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String profile_image;

    @Builder
    public User(Long id, String nickname, String email, String password, Platform platform, String profile_image) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.platform = platform;
        this.profile_image = profile_image;
    }

}
