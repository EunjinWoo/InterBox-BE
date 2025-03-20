package com.interbox.interbox_be.domain.job.entity;

import com.interbox.interbox_be.domain.job.enumerate.JobType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private JobType jobType;

    @Builder
    public Job(JobType jobType) {
        this.jobType = jobType;
    }
}
