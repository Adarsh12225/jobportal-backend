package com.jobportal.controller;

import com.jobportal.dto.ApplicationResponseDTO;
import com.jobportal.dto.ApplicationStatusUpdateDTO;
import com.jobportal.entity.Application;
import com.jobportal.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public Application applyJob(
            @RequestParam Long userId,
            @RequestParam Long jobId,
            @RequestParam String resumeLink) {

        return applicationService.applyJob(userId, jobId, resumeLink);
    }

    @PutMapping("/{id}/status")
    public ApplicationResponseDTO updateStatus(
            @PathVariable Long id,
            @RequestBody ApplicationStatusUpdateDTO request) {

        return applicationService.updateApplicationStatus(id, request.getStatus());
    }
}