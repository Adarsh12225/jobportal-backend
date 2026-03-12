package com.jobportal.service;

import com.jobportal.dto.ApplicationResponseDTO;
import com.jobportal.dto.ApplicationViewDTO;
import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.User;
import com.jobportal.exception.ResourceNotFoundException;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    public Application applyJob(Long userId, Long jobId, String resumeLink) {

        User user = userRepository.findById(userId).orElseThrow();
        Job job = jobRepository.findById(jobId).orElseThrow();

        Application application = new Application();
        application.setUser(user);
        application.setJob(job);
        application.setResumeLink(resumeLink);
        application.setStatus("APPLIED");

        return applicationRepository.save(application);
    }
    public List<ApplicationViewDTO> getApplicationsForJob(Long jobId) {
        return applicationRepository.getApplicationsForJob(jobId);
    }

    public ApplicationResponseDTO updateApplicationStatus(Long applicationId, String status) {

        Application application = applicationRepository
                .findById(applicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found"));

        application.setStatus(status);

        applicationRepository.save(application);

        return new ApplicationResponseDTO(
                application.getId(),
                application.getUser().getName(),
                application.getJob().getTitle(),
                application.getStatus()
        );
    }
}