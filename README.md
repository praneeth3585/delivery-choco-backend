# DeliveryChoco Backend API

A Food Delivery Backend System built using Java, Spring Boot, PostgreSQL, JWT Authentication, and Docker.

## Features

* User Registration & Login
* JWT Authentication
* Role-Based Access Control (Admin, Customer, Restaurant Owner)
* Restaurant Management
* Menu Management
* Cart Management
* Order Management
* Swagger API Documentation
* Docker Support

## Tech Stack

* Java 17
* Spring Boot
* Spring Security
* JWT
* PostgreSQL
* Spring Data JPA
* Maven
* Docker
* Swagger/OpenAPI

## Run Locally

```bash
mvn clean package
java -jar target/delivery-choco-api-0.0.1-SNAPSHOT.jar
```

## Run with Docker

```bash
docker compose up --build
```

## Swagger

```text
http://localhost:8081/swagger-ui/index.html
```

## Project Structure

* Controllers
* Services
* Repositories
* DTOs
* Entities
* Security (JWT)
* Exception Handling

## Author

Praneeth Challa
