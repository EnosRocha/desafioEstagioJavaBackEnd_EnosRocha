package com.example.desafioEstagioJavaBackEnd_EnosRocha.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    @Operation(summary = "Error in case of a invalid authentication", description = "The user will be redirected for this end-point where he will see that an error happend")
    @ApiResponses(value = {
            @ApiResponse(description = "Returns just a String containing error , as a matter a security, not exposing any important information")
    })
    public String handleError() {
        return "error";
    }
}
