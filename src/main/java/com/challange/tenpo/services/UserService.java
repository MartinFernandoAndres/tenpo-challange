package com.challange.tenpo.services;

import com.challange.tenpo.entitys.User;

public interface UserService {

    User registerUser(User user);
    User getUserByUsername(String username);
    boolean isUserRegistered(String username);

}