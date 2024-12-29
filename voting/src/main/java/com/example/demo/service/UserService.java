package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
//    User createUser(User user);
    public User createUser(User user);

    void saveUser(User user);
}
