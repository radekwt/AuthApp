package com.radekwt.AuthApp.services;

import com.radekwt.AuthApp.dtos.RegisterRequest;
import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.entities.User;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto deleteUser(Long UserId);
    UserDto updateUser(UserDto userDto);
    UserDto getUserById(Long userId);
    UserDto getUserByUsername(String username);
    boolean isUsernameExists(String username);

}
