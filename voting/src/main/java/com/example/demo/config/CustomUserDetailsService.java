package com.example.demo.config;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepos userRepos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user=userRepos.findByUsername(username);
            if(username== null){
                throw new UsernameNotFoundException("No user");
            }else{
                return new CustomUserDetails(user);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
