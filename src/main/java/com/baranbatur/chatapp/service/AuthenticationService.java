package com.baranbatur.chatapp.service;

import com.baranbatur.chatapp.dto.LoginUserDto;
import com.baranbatur.chatapp.dto.RegisterUserDto;
import com.baranbatur.chatapp.entity.User;
import com.baranbatur.chatapp.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setEmail(input.getEmail());
        user.setUsername(input.getUsername());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setPhone(input.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setGender(input.gender());
        user.setBirthDate(input.getBirthDate());

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
