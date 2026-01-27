package com.smarthire.backend.controller;

import com.smarthire.backend.entity.User;
import com.smarthire.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid user"));
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        return "Login_Success";

    }
}
