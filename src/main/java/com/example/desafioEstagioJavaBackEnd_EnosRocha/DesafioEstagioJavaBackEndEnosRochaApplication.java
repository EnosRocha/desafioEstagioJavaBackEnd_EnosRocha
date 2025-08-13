package com.example.desafioEstagioJavaBackEnd_EnosRocha;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "application for task management",
				version = "1.0.1",
				description = "This api was created aiming to create, update, delete and list task asinged to a authenticated user" +
						"A API itself was built using DDD (DOMAIN-DRIVEN-DESIGN) for updates to come" +
						"It contains controllers for token, user and taks. Plus, is also contain, for each task, status, priority, deadline and asigned user" +
						"The security was provided by oauth2 athorization server and oauth2 resource server through JWT acess token",
				contact = @Contact(name = "EnosRocha", email = "ens4562@gmail.com")
		)
)
public class DesafioEstagioJavaBackEndEnosRochaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioEstagioJavaBackEndEnosRochaApplication.class, args);
	}

}
