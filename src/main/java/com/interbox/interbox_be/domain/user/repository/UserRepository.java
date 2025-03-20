package com.interbox.interbox_be.domain.user.repository;

import com.interbox.interbox_be.domain.user.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"jobs"})
    @Query("SELECT u FROM User u WHERE u.id = :userId") // jobs를 함께 로딩
    Optional<User> findByIdWithJobs(Long userId);

}
