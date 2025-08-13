package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateNewUser(
        @NotBlank(message = "username cant be blank") @Size(min = 5, max = 100, message = "username must to have between 5 and 100 characteres") String name,
        @NotBlank(message = "password cat be blank") @Size(min = 5, max = 100, message = "password must to have between 5 and 100 characteres") String password
) {
}
