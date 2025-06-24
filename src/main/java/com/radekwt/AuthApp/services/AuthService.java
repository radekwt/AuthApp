package com.radekwt.AuthApp.services;

import com.radekwt.AuthApp.entities.User;

public interface AuthService {
    User registerUser();
    User loginUser();
    User logoutUser();
}
