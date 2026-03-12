package com.jobportal.dto;

public class ApplicationResponseDTO {

    private Long applicationId;
    private String candidateName;
    private String jobTitle;
    private String status;

    public ApplicationResponseDTO(Long applicationId, String candidateName, String jobTitle, String status) {
        this.applicationId = applicationId;
        this.candidateName = candidateName;
        this.jobTitle = jobTitle;
        this.status = status;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getStatus() {
        return status;
    }
}