# Task manager project - by Enos Rocha 📌
This is a API RESTful for task management. The project is written in java using spring boot as the main framework.

---

## Sumary
1. [Description](#description)
2. [Tecnologies](#tecnologies)
3. [Get Started](#get-started)
4. [How to Use it](#how-to-use-it)
5. [Endpoints](#endpoints)

---

## Description
The objective is provide a efficient solution for the task management problem in a safe and simples way.

For a clean and scalable code was a dopted a DOMAIN-DRIVEN-DESIGN(DDD), so the code is completly decoupled and even though the main framework be changed the business rules could be preserved untouched. 


Main features:
- CRUD
- Filter for filtering task by status, priority and deadline
- Authorization and authentication using JWT
- Database provided by a docker compose (ISOLATED in the ROOT of the project for deploy)
- Documentation with swagger

---

## Tecnologies
- Java 17
- Spring Boot 3.5.4
- Spring Security
- JWT 
- Swagger
- Maven
- MySQL
- Docker
- MapStruct
- JPA / Hibernate

---

## Get started

1. First step : Clone the project from github
  - ```bash git clone git@github.com:EnosRocha/desafioEstagioJavaBackEnd_EnosRocha.git ```
2. Second step: adjust the properties.yml by editing the database information
    ```yml
    spring:
      datasource:
        url: jdbc:mysql://localhost:3310/{DATABASENAME}
        username: {YOURNAME}
        password: {YOUR PASSWORD}
      jpa:
        hibernate:
          ddl-auto: update 

    
  - **OBS**: remeber of passing this edited information in the docker-compose.yml, the same way they are written in the properties.yml 
3. Third step: Build the docker container up in the project terminal
    ``` bash
    docker compose up 
4. Fourth: Run the project using maven
   ```bash
    mvn spring-boot:run 

---

## How to use it
Onde the project is running: 
  - Access Swagger UI at: http://localhost:8080/swagger-ui.html
  - For the first access the back-end will request user and password, type admin for both.
  - Create a new User so can receive a JWT token that will be used in others endpoint
  - Authenticate with JWT token to use protected endpoints
  - Use the provided endpoints for managing tasks

## Endpoints
| Method | Endpoint          | Description       | Auth Required |
| ------ | ----------------- | ----------------- | ------------- |
| POST   | `/task/create`    | Create a new task | ✅            |
| GET    | `/task/get`       | List all tasks    | ✅            |
| GET    | `/task/getauthenticateduser`  | List all task by user | ✅ |
| PUT    | `/task//updatetask/{id}` | Update a task     | ✅             |
| DELETE | `/task/deletetask` | Delete a task    | ✅            |
| POST   | `/user`            | Create a new User | ✅            |






