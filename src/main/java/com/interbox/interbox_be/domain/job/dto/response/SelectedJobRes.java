package com.interbox.interbox_be.domain.job.dto.response;

import com.interbox.interbox_be.domain.job.entity.Job;
import com.interbox.interbox_be.domain.job.enumerate.JobType;
import lombok.Builder;

import java.util.List;

@Builder
public record SelectedJobRes (
        Long id,
        JobType jobType
){
    public static SelectedJobRes of(Job job) {
        return SelectedJobRes.builder()
                .id(job.getId())
                .jobType(job.getJobType())
                .build();
    }

    public static List<SelectedJobRes> ofList(List<Job> jobs) {
        return jobs.stream()
                .map(SelectedJobRes::of) // 개별 Job을 SelectedJobRes로 변환
                .toList();
    }
}
