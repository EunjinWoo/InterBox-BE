package com.interbox.interbox_be.domain.question.entity;

import com.interbox.interbox_be.domain.job.entity.Job;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionContent;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean isSolved;

    @Builder
    public Question(String questionContent, Boolean isSolved, Job job){
        this.questionContent = questionContent;
        this.isSolved = isSolved;
        this.job = job;
    }
}
