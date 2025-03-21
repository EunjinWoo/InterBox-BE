package com.interbox.interbox_be.domain.question.dto.response;

import com.interbox.interbox_be.domain.question.entity.Question;
import lombok.Builder;

@Builder
public record QuestionRes (
        Long id,
        String questionContent,
        Boolean isSolved
) {
    public static QuestionRes of(Question question, Boolean isSolved) {
        return QuestionRes.builder()
                .id(question.getId())
                .questionContent(question.getQuestionContent())
                .isSolved(isSolved)
                .build();
    }
}

