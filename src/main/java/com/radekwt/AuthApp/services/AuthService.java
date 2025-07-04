package com.radekwt.AuthApp.services;

import com.radekwt.AuthApp.dtos.LoginRequest;
import com.radekwt.AuthApp.dtos.LoginResponse;
import com.radekwt.AuthApp.dtos.RegisterRequest;
import com.radekwt.AuthApp.dtos.UserDto;

public interface AuthService {
    UserDto registerUser(RegisterRequest registerRequest);
    LoginResponse loginUser(LoginRequest loginRequest);
}
