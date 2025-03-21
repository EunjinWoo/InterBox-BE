package com.interbox.interbox_be.domain.question.repository;

import com.interbox.interbox_be.domain.question.entity.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // 특정 직군의 질문 리스트 조회
    List<Question> findByJobId(Long jobId);

    @EntityGraph(attributePaths = {"job"})
    Optional<Question> findById(Long id);
}
