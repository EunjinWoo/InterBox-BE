package com.interbox.interbox_be.domain.job.repository;

import com.interbox.interbox_be.domain.job.entity.Job;
import com.interbox.interbox_be.domain.job.enumerate.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<Job> findByJobType(JobType jobType);
}
