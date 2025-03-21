package com.interbox.interbox_be.domain.question.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.interbox.interbox_be.domain.answer.entity.Answer;
import com.interbox.interbox_be.domain.job.entity.Job;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    @Builder
    public Question(String questionContent, Job job) {
        this.questionContent = questionContent;
        this.job = job;
    }
}
