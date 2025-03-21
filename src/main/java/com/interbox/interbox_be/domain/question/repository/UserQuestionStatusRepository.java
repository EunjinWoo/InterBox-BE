package com.interbox.interbox_be.domain.question.repository;

import com.interbox.interbox_be.domain.question.entity.UserQuestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserQuestionStatusRepository extends JpaRepository<UserQuestionStatus, Long> {
    Optional<UserQuestionStatus> findByUserIdAndQuestionId(Long userId, Long questionId);
}
