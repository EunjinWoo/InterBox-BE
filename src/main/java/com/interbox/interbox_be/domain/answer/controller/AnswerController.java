package com.interbox.interbox_be.domain.answer.controller;

import com.interbox.interbox_be.domain.answer.dto.request.AnswerCreateReq;
import com.interbox.interbox_be.domain.answer.dto.response.AnswerRes;
import com.interbox.interbox_be.domain.answer.service.AnswerService;
import com.interbox.interbox_be.global.response.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/{userId}/{questionId}")
    public ApplicationResponse<AnswerRes> addAnswer(
            @PathVariable Long userId,
            @PathVariable Long questionId,
            @RequestBody AnswerCreateReq req) {

        AnswerRes answer = answerService.saveAnswer(userId, questionId, req.answerContent());
        return ApplicationResponse.ok(answer);
    }

}
