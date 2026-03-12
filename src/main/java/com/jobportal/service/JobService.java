package com.jobportal.service;

import com.jobportal.dto.JobRequestDTO;
import com.jobportal.dto.RecruiterJobDTO;
import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job createJob(JobRequestDTO jobRequest) {

        Job job = new Job();

        job.setTitle(jobRequest.getTitle());
        job.setCompany(jobRequest.getCompany());
        job.setLocation(jobRequest.getLocation());
        job.setDescription(jobRequest.getDescription());
        job.setSalary(jobRequest.getSalary());

        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public Page<Job> searchJobsByLocation(String location, Pageable pageable) {
        return jobRepository.findByLocation(location, pageable);
    }

    public Page<Job> searchJobsByTitle(String title, Pageable pageable) {
        return jobRepository.findByTitleContaining(title, pageable);
    }

    public List<RecruiterJobDTO> getRecruiterJobs(Long recruiterId) {
        return jobRepository.getRecruiterJobs(recruiterId);
    }

}