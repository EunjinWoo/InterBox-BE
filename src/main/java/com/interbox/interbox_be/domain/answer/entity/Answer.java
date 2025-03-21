package com.interbox.interbox_be.domain.answer.entity;

import com.interbox.interbox_be.domain.question.entity.Question;
import com.interbox.interbox_be.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String answerContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Answer(String answerContent, Question question, User user) {
        this.answerContent = answerContent;
        this.question = question;
        this.user = user;
    }
}
