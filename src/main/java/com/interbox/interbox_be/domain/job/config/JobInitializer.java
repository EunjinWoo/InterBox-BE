package com.interbox.interbox_be.domain.job.config;

import com.interbox.interbox_be.domain.job.entity.Job;
import com.interbox.interbox_be.domain.job.enumerate.JobType;
import com.interbox.interbox_be.domain.job.repository.JobRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobInitializer {
    private final JobRepository jobRepository;

    @PostConstruct
    public void init() {
        if (jobRepository.count() == 0) { // 기존 데이터가 없으면 추가
            for (JobType jobType : JobType.values()) {
                jobRepository.save(new Job(jobType));
            }
        }
    }
}
