package com.jobportal.repository;

import com.jobportal.dto.ApplicationViewDTO;
import com.jobportal.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Query("""
SELECT new com.jobportal.dto.ApplicationViewDTO(
    u.name,
    u.email,
    a.resumeLink,
    a.status
)
FROM Application a
JOIN a.user u
JOIN a.job j
WHERE j.id = :jobId
""")
    List<ApplicationViewDTO> getApplicationsForJob(Long jobId);
}