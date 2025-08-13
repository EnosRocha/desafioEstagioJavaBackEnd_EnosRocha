package com.example.desafioEstagioJavaBackEnd_EnosRocha.application.services;

import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.dto.CreateNewUser;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.exceptions.UserAlreadyExistsException;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.application.mappers.UserMapper;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.entity.User;
import com.example.desafioEstagioJavaBackEnd_EnosRocha.domain.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServices(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Transactional
    public User createNewUserService(CreateNewUser createNewUser){
        Optional<User> userFound = userRepository.findByName(createNewUser.name());
        if(userFound.isPresent()){
            throw  new UserAlreadyExistsException("user already exists in database");
        }
        String encondedPassword = passwordEncoder.encode(createNewUser.password());
        User finalUser = userMapper.toDomain(createNewUser,encondedPassword);
        return userRepository.save(finalUser);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name)
                .map(u -> org.springframework.security.core.userdetails.User.builder()
                        .username(u.getName())
                        .password(u.getPassword())
                        .roles("USER")
                        .build()).orElseThrow(() -> new EntityExistsException("user not found in database"));
    }
}
