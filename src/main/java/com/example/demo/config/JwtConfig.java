package com.example.demo.config;

import com.example.demo.security.JwtTokenProvider;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;
import java.util.Base64;

@Configuration
public class JwtConfig {

    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        // Generate a secure 256-bit key
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // Convert to Base64 so JwtTokenProvider can accept it as String
        String secret = Base64.getEncoder().encodeToString(key.getEncoded());

        return new JwtTokenProvider(secret, 3600000);
    }
}
