package com.jobportal.repository;
import java.util.List;

import com.jobportal.dto.RecruiterJobDTO;
import com.jobportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByLocation(String location);
    Page<Job> findByLocation(String location, Pageable pageable);

    Page<Job> findByTitleContaining(String title, Pageable pageable);


    @Query("""
SELECT new com.jobportal.dto.RecruiterJobDTO(
    j.title,
    j.company,
    COUNT(a.id)
)
FROM Job j
LEFT JOIN Application a ON a.job.id = j.id
WHERE j.recruiter.id = :recruiterId
GROUP BY j.id
""")
    List<RecruiterJobDTO> getRecruiterJobs(Long recruiterId);
}


