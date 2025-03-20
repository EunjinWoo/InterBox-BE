package com.interbox.interbox_be.domain.job.enumerate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JobType {
    FRONT_END("프론트엔드 개발자"),
    BACK_END("백엔드 개발자"),
    DATA_ANALYST("데이터 분석가"),
    DATA_ENGINEER("데이터 엔지니어"),
    DATA_SCIENTIST("데이터 사이언티스트");

    private final String description;
}
