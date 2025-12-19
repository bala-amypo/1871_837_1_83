package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository repo, JwtTokenProvider jwt) {}

    @Override
    public User register(String email, String password, String role) {
        User u = new User();
        u.setEmail(email);
        u.setRole(role);
        return u;
    }

    @Override
    public User login(String email, String password) {
        throw new RuntimeException("User not found");
    }

    @Override
    public User getByEmail(String email) {
        throw new RuntimeException("User not found");
    }
}
