package com.example.desafioEstagioJavaBackEnd_EnosRocha.security;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

    @Bean
    CommandLineRunner LoadAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if(userRepository.findByName("admin").isEmpty()){
                User admin = new User("admin",passwordEncoder.encode("admin"));
                userRepository.save(admin);
            }else{
                System.out.println("USER ADMIN ALREADY EXISTS");
            }
        };
    }
}
