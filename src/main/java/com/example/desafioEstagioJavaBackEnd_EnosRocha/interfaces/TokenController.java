package com.example.desafioEstagioJavaBackEnd_EnosRocha.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/token")
@Tag(name = "token-controller", description = "It will be used just for ckecking on the token, to see whether is present or not")
public class TokenController {

    @GetMapping("/")
    @Operation(summary = "Verify the token", description = "Onde the user had been authenticated it will return a valid token for cheking on the user.This rout is protected")
    @ApiResponses(value = {
            @ApiResponse(description = "Returns a map with the token values")
    })
    public ResponseEntity<Map<String, Object>> home(
            @Parameter(description = "Authentication object the contains the values of the token, but its not de Bearer token to do requests as a matter os security") Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok(Map.of(
                    "message", "Bem-vindo!",
                    "username", authentication.getName(),
                    "authorities", authentication.getAuthorities().toString()
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
