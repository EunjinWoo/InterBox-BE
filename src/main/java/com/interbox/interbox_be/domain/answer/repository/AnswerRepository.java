package com.interbox.interbox_be.domain.answer.repository;

import com.interbox.interbox_be.domain.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    // 특정 유저가 특정 질문에 이미 답변을 남겼는지 확인
    Optional<Answer> findByUserIdAndQuestionId(Long userId, Long questionId);
}
