# REST API - Spring Boot - H2

## Description - Exercise statement
This project implements a REST API to manage fruit stock using Spring Boot and an in-memory H2 database.
The API allows registering, retrieving, updating, and deleting fruits, storing their name and weight in kilos.

## Technologies used
- Oracle OpenJDK 21.0.8
- Spring Boot 3.5.8
- Maven 3.9.11
- H2 Database
- Postman
- IntelliJ IDEA Community Edition

## Requirements
- Oracle OpenJDK 21.0.8
- Spring Boot 3.5.8
- Maven 3.9.11
- Java IDE

## Installation
1. Clone repository (https://github.com/AlbertMedina/4.2-Spring-Framework-Basics-Nivell1.git).
```git clone https://github.com/AlbertMedina/4.2-Spring-Framework-Basics-Nivell1.git```
2. Navigate to project folder.
```cd fruit-api-h2```

## Execution
1. Run the application from your IDE or using Maven from the terminal.
```mvn spring-boot:run```
The API will be available at http://localhost:8080.
2. Test endpoints with Postman or any HTTP client.
- Example endpoints:
  - POST / GET -> /fruits
  - GET / PUT / DELETE -> /fruits/{id}
- Example POST JSON:
```
{
  "name": "Watermelon",
  "weightInKg": 2
}
```
