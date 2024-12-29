package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vote")
public class LoginController {

    @PostMapping("/authenticateUser")
    public ResponseEntity<String> authenticateUser(@RequestBody User user) {
    // 1. Validate input
    if (user.getUsername() == null || user.getPassword() == null) {
        return ResponseEntity.badRequest().body("Username and password must not be null");
    }

    // 2. Example: Fetch user details (e.g., from a database)
    String hardcodedUsername = "admin";
    String hardcodedPassword = "1234"; // In real applications, passwords should be hashed

    // 3. Verify credentials
    if (hardcodedUsername.equals(user.getUsername()) &&
        hardcodedPassword.equals(user.getPassword())) {
        return ResponseEntity.ok("User authenticated");
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
}
