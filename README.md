# Task manager project - by Enos Rocha 📌
This is a API RESTful for task management. The project is written in java using spring boot as the main. framework.

---

## Sumary
1. [Description](#description)
2. [Tecnologies](#tecnologies)
3. [Get Started](#getstarted)
4. [Docker](#docker)
5. [Endpoints](#endpoints)

---

## Description
The objective is provide a efficient solution for the task management problem in a safe and simples way.

Main features:
- CRUD
- Filter for filtering task by status, priority and deadline
- Authorization and authentication using JWT
- Database provided by a docker compose (ISOLATED in the ROOT of the project for deploy)
- Documentation with sweagger

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

## Getstarted

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
          ddl-auto: update ```

    
    - **OBS: remeber of passing this edited information in the docker-compose.yml, the same way they are written in the properties.yml **
3. Second step: Build the docker container up in the project terminal
  - ``` bash docker compose up ```




