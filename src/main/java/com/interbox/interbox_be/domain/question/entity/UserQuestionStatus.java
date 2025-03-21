package com.interbox.interbox_be.domain.question.entity;

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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "question_id"})})
public class UserQuestionStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(nullable = false)
    private Boolean isSolved;

    @Builder
    public UserQuestionStatus(User user, Question question, Boolean isSolved) {
        this.user = user;
        this.question = question;
        this.isSolved = isSolved;
    }

    public void markSolved() {
        this.isSolved = true;
    }
}
