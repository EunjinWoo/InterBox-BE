package com.interbox.interbox_be.domain.answer.dto.response;

import com.interbox.interbox_be.domain.answer.entity.Answer;
import lombok.Builder;

@Builder
public record AnswerRes(
        Long id,
        String answerContent,
        Long questionId,
        Long userId
) {
    public static AnswerRes of(Answer answer) {
        return AnswerRes.builder()
                .id(answer.getId())
                .answerContent(answer.getAnswerContent())
                .questionId(answer.getQuestion().getId())
                .userId(answer.getUser().getId())
                .build();
    }
}
