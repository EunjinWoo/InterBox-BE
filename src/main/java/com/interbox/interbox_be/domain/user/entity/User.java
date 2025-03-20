package com.interbox.interbox_be.domain.user.entity;

import com.interbox.interbox_be.domain.job.entity.Job;
import com.interbox.interbox_be.domain.user.enumerate.Platform;
import com.interbox.interbox_be.global.common.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@SQLDelete(sql = "UPDATE user SET deleted_at = NOW() where id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_job",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<Job> jobs; // 유저가 선택한 직군 리스트

    @Column(nullable = false, columnDefinition = "TEXT")
    private String nickname;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String profile_image;

    @Builder
    public User(Long id, String nickname, String email, String password, Platform platform, String profile_image, List<Job> jobs) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.platform = platform;
        this.profile_image = profile_image;
        this.jobs = (jobs != null) ? jobs : new ArrayList<>();
    }

    public void updateJobs(List<Job> jobs) {
        this.jobs.clear();
        this.jobs.addAll(jobs);
    }

}
