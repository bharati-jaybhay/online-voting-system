package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepos userRepos;


    @Override
    public User createUser(User user) {
        return userRepos.save(user);
    }

    @Override
    public void saveUser(User user) {
        System.out.println("Saving user: " + user);
        userRepos.save(user);
    }
}
