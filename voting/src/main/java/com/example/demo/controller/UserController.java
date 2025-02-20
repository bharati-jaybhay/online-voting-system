package com.example.demo.controller;

import com.example.demo.model.Candidate;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CandidateService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            System.out.println("🔍 Attempting login for: " + username);
            System.out.println("🔑 Entered Password: " + password);

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("✅ Authentication successful! Redirecting...");
            return "redirect:/home";

        } catch (BadCredentialsException e) {
            System.out.println("❌ Authentication failed: Invalid username or password.");
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }


    @GetMapping("/register/add")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.saveUser(user);
        model.addAttribute("successMessage", "Registration successful! Please login.");
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String showHomePage(Model model) {
        List<Candidate> candidates = candidateService.getAllCandidates();
        model.addAttribute("AllCandidates", candidates);
        return "home";
    }
}
