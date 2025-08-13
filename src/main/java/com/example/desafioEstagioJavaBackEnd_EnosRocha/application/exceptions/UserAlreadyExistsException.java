package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
