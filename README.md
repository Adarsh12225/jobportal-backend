A robust backend for a Job Portal demonstrating clean architecture, authentication, REST APIs, database design, and security.
🌟 Features

✅ Clean backend architecture

✅ Authentication & Authorization (JWT)

✅ RESTful APIs

✅ Secure password handling & validation

✅ Well-structured database design

👥 Roles
👨‍💼 Employer

Post jobs

Edit jobs

View applicants

👨‍🎓 Job Seeker

Register / Login

Apply for jobs

Upload resume

Track applications

👑 Admin

Manage users

Manage jobs

Monitor platform


job-portal-backend
│
├── controller   # Handles HTTP requests
├── service      # Business logic
├── repository   # Database interactions
├── entity       # Database tables
├── dto          # Data transfer objects
├── config       # Application configuration
├── security     # JWT authentication
├── exception    # Global exception handling
├── util         # Utility classes
└── JobPortalApplication.java

| Layer      | Purpose                                 |
| ---------- | --------------------------------------- |
| Controller | Handles incoming HTTP requests          |
| Service    | Contains business logic                 |
| Repository | Interacts with the database             |
| Entity     | Represents database tables              |
| DTO        | Data transfer objects for API responses |
| Security   | JWT authentication                      |
| Config     | Application configuration               |
| Exception  | Global exception handling               |



🗄 Database Design
USERS

id, name, email, password, role (ADMIN / EMPLOYER / JOB_SEEKER), created_at

JOBS

id, title, description, salary, location, company_name, posted_by, created_at

APPLICATIONS

id, job_id, user_id, resume_url, status (APPLIED / SHORTLISTED / REJECTED), applied_at

⚙️ Dependencies

Spring Web

Spring Data JPA

MySQL Driver

Lombok

Validation

Spring Boot DevTools
