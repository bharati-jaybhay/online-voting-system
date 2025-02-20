package com.example.demo.service;

import com.example.demo.model.User;
import jakarta.validation.Valid;

public interface UserService {

    User saveUser(User user);

    User findByUsername( String username);

}
