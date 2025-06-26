package com.radekwt.AuthApp.services;

import com.radekwt.AuthApp.dtos.UserDto;
import com.radekwt.AuthApp.entities.User;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto deleteUser();
    UserDto updateUser();
    UserDto getUser();

}
