package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions;

public class TaskAlreadyExistException extends RuntimeException {
    public TaskAlreadyExistException(String message) {
        super(message);
    }
}
