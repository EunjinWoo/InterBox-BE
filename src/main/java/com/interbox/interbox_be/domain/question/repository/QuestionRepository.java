package com.interbox.interbox_be.domain.question.repository;

import com.interbox.interbox_be.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // 특정 직군의 질문 리스트 조회
    List<Question> findByJobId(Long jobId);
}
