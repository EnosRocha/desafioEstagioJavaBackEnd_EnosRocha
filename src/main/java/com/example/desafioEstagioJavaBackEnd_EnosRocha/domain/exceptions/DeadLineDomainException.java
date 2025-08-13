package com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.exceptions;

public class DeadLineDomainException extends RuntimeException {
    public DeadLineDomainException(String message) {
        super(message);
    }
}
