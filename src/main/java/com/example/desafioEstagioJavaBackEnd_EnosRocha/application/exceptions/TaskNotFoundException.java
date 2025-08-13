package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
