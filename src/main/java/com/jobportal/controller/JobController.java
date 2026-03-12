package com.jobportal.controller;

import com.jobportal.dto.ApplicationViewDTO;
import com.jobportal.dto.JobRequestDTO;
import com.jobportal.dto.RecruiterJobDTO;
import com.jobportal.entity.Job;
import com.jobportal.service.ApplicationService;
import com.jobportal.service.JobService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/api/jobs")



public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping
    public Job createJob(@Valid @RequestBody JobRequestDTO jobRequest) {
        return jobService.createJob(jobRequest);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/search/location")
    public Page<Job> searchByLocation(
            @RequestParam String location,
            @RequestParam int page,
            @RequestParam int size) {

        return jobService.searchJobsByLocation(location, PageRequest.of(page, size));
    }

    @GetMapping("/search/title")
    public Page<Job> searchByTitle(
            @RequestParam String title,
            @RequestParam int page,
            @RequestParam int size) {

        return jobService.searchJobsByTitle(title, PageRequest.of(page, size));
    }
    @GetMapping("/recruiter/{id}")
    public List<RecruiterJobDTO> getRecruiterJobs(@PathVariable Long id) {
        return jobService.getRecruiterJobs(id);
    }

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/{jobId}/applications")
    public List<ApplicationViewDTO> getApplications(@PathVariable Long jobId) {
        return applicationService.getApplicationsForJob(jobId);
    }
}