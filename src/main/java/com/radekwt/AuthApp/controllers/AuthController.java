package com.radekwt.AuthApp.controllers;

import com.radekwt.AuthApp.dtos.LoginRequest;
import com.radekwt.AuthApp.dtos.LoginResponse;
import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.services.AuthService;
import com.radekwt.AuthApp.services.impl.JwtService;
import jakarta.validation.Valid;
import com.radekwt.AuthApp.dtos.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final JwtService jwtService;
    private final AuthService authService;
    public AuthController(AuthService authService,JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody RegisterRequest registerRequest){
        UserDto userDto = authService.registerUser(registerRequest);
        return ResponseEntity.ok(userDto);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.loginUser(loginRequest));
    }
    @PostMapping("/logout")
    public ResponseEntity<UserDto> logoutUser(){
        return ResponseEntity.ok(new UserDto());
    }

}
