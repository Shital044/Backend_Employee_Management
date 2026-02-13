Backend Employee Management System

A RESTful backend application built using Spring Boot to manage employees, departments, and reporting relationships.
This project demonstrates clean API design, database integration, business rules, and logging middleware.

Features

Create, update, delete employees

Assign department and manager

Prevent deleting a department that has employees

When a manager is deleted, subordinates are reassigned to NULL

Automatic timestamps (created & updated)

REST APIs with JSON

Postman collection for testing

 Technologies Used

Java 17+

Spring Boot

Spring Data JPA (Hibernate)

MySQL

Maven

Postman (for API testing)
