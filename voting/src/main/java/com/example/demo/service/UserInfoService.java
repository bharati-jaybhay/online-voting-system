package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(User user) {
        String encodePassword = passwordEncoder.encode(user.getPassword());

        // Default Role for every user who register themself through browser
        String role = "ROLE_USER";

        user.setPassword(encodePassword);
        user.setRoles(role);

        userRepos.save(user);

        return "User Saved Successfully";
    }
}
