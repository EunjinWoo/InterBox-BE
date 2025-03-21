package com.interbox.interbox_be.domain.question.service;

import com.interbox.interbox_be.domain.question.dto.response.QuestionRes;
import com.interbox.interbox_be.domain.question.entity.Question;
import com.interbox.interbox_be.domain.question.entity.UserQuestionStatus;
import com.interbox.interbox_be.domain.question.repository.QuestionRepository;
import com.interbox.interbox_be.domain.question.repository.UserQuestionStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserQuestionStatusRepository userQuestionStatusRepository;

    // 특정 직군(jobId)에 대한 질문 리스트 반환
    @Transactional(readOnly = true)
    public List<QuestionRes> getQuestionsByJob(Long jobId, Long userId) {
        List<Question> questions = questionRepository.findByJobId(jobId);
        return questions.stream()
                .map(question -> {
                    boolean isSolved = userQuestionStatusRepository
                            .findByUserIdAndQuestionId(userId, question.getId())
                            .map(UserQuestionStatus::getIsSolved)
                            .orElse(false);

                    return QuestionRes.of(question, isSolved);
                })
                .toList();
    }
}

