package com.interbox.interbox_be.domain.answer.service;

import com.interbox.interbox_be.domain.answer.dto.response.AnswerRes;
import com.interbox.interbox_be.domain.answer.entity.Answer;
import com.interbox.interbox_be.domain.answer.repository.AnswerRepository;
import com.interbox.interbox_be.domain.question.entity.Question;
import com.interbox.interbox_be.domain.question.entity.UserQuestionStatus;
import com.interbox.interbox_be.domain.question.repository.QuestionRepository;
import com.interbox.interbox_be.domain.question.repository.UserQuestionStatusRepository;
import com.interbox.interbox_be.domain.user.entity.User;
import com.interbox.interbox_be.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final UserQuestionStatusRepository userQuestionStatusRepository;

    @Transactional
    public AnswerRes saveAnswer(Long userId, Long questionId, String answerContent) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("질문을 찾을 수 없습니다."));

        // 중복 답변 방지
        answerRepository.findByUserIdAndQuestionId(userId, questionId)
                .ifPresent(a -> {
                    throw new RuntimeException("이미 해당 질문에 답변을 남겼습니다.");
                });

        Answer answer = Answer.builder()
                .answerContent(answerContent)
                .question(question)
                .user(user)
                .build();
        answerRepository.save(answer);

        // 유저별 isSolved 관리
        UserQuestionStatus userQuestionStatus = userQuestionStatusRepository
                .findByUserIdAndQuestionId(userId, questionId)
                .orElseGet(() -> UserQuestionStatus.builder()
                        .user(user)
                        .question(question)
                        .isSolved(false)
                        .build());

        userQuestionStatus.markSolved();
        userQuestionStatusRepository.save(userQuestionStatus);

        return AnswerRes.of(answer);
    }


}
