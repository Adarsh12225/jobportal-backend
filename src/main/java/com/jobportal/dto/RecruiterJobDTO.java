package com.jobportal.dto;

public class RecruiterJobDTO {

    private String jobTitle;
    private String company;
    private Long applications;

    public RecruiterJobDTO(String jobTitle, String company, Long applications) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.applications = applications;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public Long getApplications() {
        return applications;
    }
}