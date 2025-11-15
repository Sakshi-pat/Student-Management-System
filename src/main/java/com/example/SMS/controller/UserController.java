package com.example.SMS.controller;

import com.example.SMS.entity.User;
import com.example.SMS.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return "User not found!";
        }

        if (user.getPassword().equals(password)) {
            return "Login successful!";
        } else {
            return "Invalid password!";
        }
    }
}
