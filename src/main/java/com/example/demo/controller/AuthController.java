package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public AuthController(UserService s, JwtTokenProvider jwt) {}

    @PostMapping("/register")
    public User register(@RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String role) {
        return null;
    }

    @PostMapping("/login")
    public Object login(@RequestParam String email,
                        @RequestParam String password) {
        return null;
    }
}
