package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions;

public class TaskCantBeCompletedException extends RuntimeException {
    public TaskCantBeCompletedException(String message) {
        super(message);
    }
}
