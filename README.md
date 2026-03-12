
This project demonstrates:
|->Clean backend architecture
|->Authentication system
|->REST APIs
|->Database design
|->Security

In this job portal we have 3 role --> 👨‍💼 Employer,👨‍🎓 Job Seeker,👑 Admin

|->👨‍💼 Employer
|->Post jobs,Edit jobs,View applicants
|->👨‍🎓 Job Seeker
|->Register / login,Apply for jobs,Upload resume,Track applications
|->👑 Admin
|->Manage users,Manage jobs,Monitor platform

project Structure
job-portal-backend
│
├── controller
│
├── service
│
├── repository
│
├── entity
│
├── dto
│
├── config
│
├── security
│
├── exception
│
├── util
│
└── JobPortalApplication.java


Purpose of Each Layer

Controller --> Handles HTTP requests
Service --> Business logic
Repository --> Database interaction
Entity --> Database tables
DTO --> Data transfer objects
Security ->JWT authentication
Config -->Application configuration
Exception --> Global exception handling

Database Design

Main tables:

USERS
->id
->name
->email
->password
->role
->created_at

Role:

ADMIN
EMPLOYER
JOB_SEEKER
JOBS
->id
->title
->description
->salary
->location
->company_name
->posted_by
->created_at
->APPLICATIONS
->id
->job_id
->user_id
->resume_url
->status
->applied_at

Status:

->APPLIED
->SHORTLISTED
->REJECTED

Add Dependencies
|->Spring Web
|->Spring Data JPA
|->MySQL Driver
|->Lombok
|->Validation
|->Spring Boot DevTools

















