package com.example.desafioEstagioJavaBackEnd_EnosRocha.interfaces;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.CreateNewUser;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.services.UserServices;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ranges.RangeException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping
    @Operation(summary = "Create a new user for authorization and authentication services", description = "Create a new user through the given @Valid DTO")
    @ApiResponses(value = {

            @ApiResponse(responseCode = "201", description = "User has been created"),
            @ApiResponse(responseCode = "400", description = "Invalid DTO for creating user")
    })
    public ResponseEntity createNewUserController(
            @Parameter(description = "DTO caontaining data for creating a new user ")
            @Valid @RequestBody CreateNewUser createNewUser) {
        User user = userServices.createNewUserService(createNewUser);
        return user != null ? ResponseEntity.status(HttpStatus.CREATED).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
