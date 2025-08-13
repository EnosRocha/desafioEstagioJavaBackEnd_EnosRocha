package com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.exceptions;

public class UserSignUpNotAllowedException extends RuntimeException {
    public UserSignUpNotAllowedException(String message) {
        super(message);
    }
}
