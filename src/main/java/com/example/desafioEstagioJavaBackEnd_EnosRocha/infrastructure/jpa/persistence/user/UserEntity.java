package com.example.desafioEstagioJavaBackEnd_EnosRocha.infrastructure.jpa.persistence.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "name cant be blank")
    @Size(min = 5, max = 100, message = "username must to have between 5 and 100 characteres")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "password cant be blank")
    @Size(min = 5, max = 100, message = "password must to have between 5 and 100 characteres")
    private String password;

}
