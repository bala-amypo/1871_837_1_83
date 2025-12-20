package com.example.demo.config;

import com.example.demo.security.JwtTokenProvider;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        // ✅ Secure 256-bit key
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return new JwtTokenProvider(key, 3600000); // 1 hour
    }
}
