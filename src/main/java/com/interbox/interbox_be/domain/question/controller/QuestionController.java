package com.interbox.interbox_be.domain.question.controller;

import com.interbox.interbox_be.domain.question.dto.response.QuestionRes;
import com.interbox.interbox_be.domain.question.service.QuestionService;
import com.interbox.interbox_be.global.response.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{jobId}")
    public ApplicationResponse<List<QuestionRes>> getQuestionsByJob(@PathVariable Long jobId){
        List<QuestionRes> questions = questionService.getQuestionsByJob(jobId);
        return ApplicationResponse.ok(questions);
    }
}
