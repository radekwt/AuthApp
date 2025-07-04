package com.radekwt.AuthApp.services.impl;

import com.radekwt.AuthApp.dtos.LoginRequest;
import com.radekwt.AuthApp.dtos.LoginResponse;
import com.radekwt.AuthApp.dtos.RegisterRequest;
import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.exceptions.EmailAlreadyExistsException;
import com.radekwt.AuthApp.exceptions.UsernameAlreadyExistsException;
import com.radekwt.AuthApp.mappers.UserMapper;
import com.radekwt.AuthApp.services.AuthService;
import com.radekwt.AuthApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AuthServiceImpl(
            UserMapper userMapper,
            UserService userService,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ){
        this.userMapper = userMapper;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    @Override
    public UserDto registerUser(RegisterRequest request) {
        if(userService.isUsernameExists(request.getUsername())){
            throw new UsernameAlreadyExistsException(request.getUsername());
        }
        UserDto userDto = userMapper.toDto(request);
        userDto.setPassword(passwordEncoder.encode(request.getPassword()));

        return userService.createUser(userDto);
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {
        System.out.println(userService.getUserByUsername(request.getUsername()));
        System.out.println(request);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return new LoginResponse(token, jwtService.getExpirationTime());
    }

}
