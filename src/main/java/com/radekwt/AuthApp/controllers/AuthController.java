package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.services.AuthService;
import jakarta.validation.Valid;
import com.radekwt.AuthApp.dtos.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody RegisterRequest registerRequest){
        UserDto token = authService.registerUser(registerRequest);
        return ResponseEntity.ok(new UserDto());
    }
    @PostMapping("/login")
    public RegisterRequest loginUser(){
        return new RegisterRequest();
    }
    @PostMapping("/logout")
    public RegisterRequest logoutUser(){
        return new RegisterRequest();
    }

}
