# Project-Management-System-API

This is a RESTful API for a Project Management System built using Java 17 and Spring Boot. The API supports CRUD operations (Create, Read, Update, Delete) for managing project information and uses an in-memory H2 database for data persistence.

## Prerequisites

- Java 17
- Maven
- IDE (IntelliJ, Eclipse, etc.)

## Project Setup

1. Initialize a new Spring Boot project using [Spring Initializr](https://start.spring.io/).
2. Include dependencies: `Spring Web`, `Spring Data JPA`, `H2 Database`.
3. Download the project and open it in your IDE.

## Database Configuration

Configure the H2 in-memory database in `src/main/resources/application.properties`:

- spring.datasource.url=jdbc:mysql://localhost:3306/ProjectManagementSystem
- spring.datasource.username=username
- spring.datasource.password=password
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

- spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER
