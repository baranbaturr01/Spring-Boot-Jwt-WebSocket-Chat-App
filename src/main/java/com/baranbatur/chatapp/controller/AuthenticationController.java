package com.baranbatur.chatapp.controller;

import com.baranbatur.chatapp.dto.request.LoginUserDto;
import com.baranbatur.chatapp.dto.request.RegisterUserDto;
import com.baranbatur.chatapp.dto.response.LoginResponse;
import com.baranbatur.chatapp.entity.User;
import com.baranbatur.chatapp.repository.RoleRepository;
import com.baranbatur.chatapp.service.AuthenticationService;
import com.baranbatur.chatapp.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final RoleRepository roleRepository;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService,
                                    RoleRepository roleRepository) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
