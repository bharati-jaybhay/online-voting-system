package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepos;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vote")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/home")
    public String showRegisterForm() {
        return "register"; // Refers to register.html in the templates folder
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user ,BindingResult theBindingResult) {
            // save the employee
            userService.saveUser(user);
            // use redirect to prevent duplicate submissions
            return "redirect:/dashboard";
        }
}
