package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final JwtTokenProvider jwt;

    public AuthController(UserService service, JwtTokenProvider jwt) {
        this.service = service;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public User register(@RequestBody AuthRequest req) {
        return service.register(
                req.getEmail(),
                req.getPassword(),
                req.getRole()
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {

        User user = service.login(
                req.getEmail(),
                req.getPassword()
        );

        String token = jwt.createToken(
                user.getEmail(),
                user.getRole(),
                user.getId()
        );

        return new AuthResponse(
                token,
                user.getEmail(),
                user.getRole()
        );
    }
}
