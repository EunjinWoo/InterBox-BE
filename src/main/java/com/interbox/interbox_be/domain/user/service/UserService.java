package com.interbox.interbox_be.domain.user.service;

import com.interbox.interbox_be.domain.job.dto.request.JobTypeReq;
import com.interbox.interbox_be.domain.job.dto.response.SelectedJobRes;
import com.interbox.interbox_be.domain.job.entity.Job;
import com.interbox.interbox_be.domain.job.enumerate.JobType;
import com.interbox.interbox_be.domain.job.repository.JobRepository;
import com.interbox.interbox_be.domain.user.dto.request.UserCreateReq;
import com.interbox.interbox_be.domain.user.entity.User;
import com.interbox.interbox_be.domain.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    @Transactional
    public User createUser(UserCreateReq request) {
        // 사용자가 선택한 직군 목록을 JobType으로 변환
        List<Job> selectedJobs = request.jobTypes().stream()
                .map(jobTypeStr -> jobRepository.findByJobType(JobType.valueOf(jobTypeStr))
                        .orElseThrow(() -> new IllegalArgumentException("해당 직군이 존재하지 않습니다: " + jobTypeStr)))
                .toList();

        User user = User.builder()
                .nickname(request.nickname())
                .email(request.email())
                .password(request.password())
                .platform(request.platform())
                .profile_image(request.profile_image())
                .jobs(selectedJobs)
                .build();
        return userRepository.save(user);
    }

    @Transactional
    public User getUserWithJobs(Long userId) {
        User user = userRepository.findByIdWithJobs(userId)
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다: " + userId));
        return user;
    }

    public User updateUserJobs(Long userId, List<String> jobTypeStrings) {
        User user = userRepository.findByIdWithJobs(userId)
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다: " + userId));

        // 요청된 직군 문자열을 실제 Job 엔티티로 변환
        List<Job> selectedJobs = jobTypeStrings.stream()
                .map(jobTypeStr -> jobRepository.findByJobType(JobType.valueOf(jobTypeStr))
                        .orElseThrow(() -> new IllegalArgumentException("해당 직군이 존재하지 않습니다: " + jobTypeStr)))
                .collect(Collectors.toList());

        // 기존 직군을 새로운 직군 리스트로 교체
        user.updateJobs(selectedJobs);

        return userRepository.save(user);
    }
}
