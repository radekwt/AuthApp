package com.radekwt.AuthApp.services;

import com.radekwt.AuthApp.entities.User;

public interface UserService {
    User createUser();
    User deleteUser();
    User updateUser();
    User getUser();

}
