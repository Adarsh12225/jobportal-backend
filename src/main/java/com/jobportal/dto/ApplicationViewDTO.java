package com.jobportal.dto;

public class ApplicationViewDTO {

    private String candidateName;
    private String email;
    private String resumeLink;
    private String status;

    public ApplicationViewDTO(String candidateName, String email, String resumeLink, String status) {
        this.candidateName = candidateName;
        this.email = email;
        this.resumeLink = resumeLink;
        this.status = status;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getEmail() {
        return email;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public String getStatus() {
        return status;
    }
}