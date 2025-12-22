package com.example.demo.config;

import com.example.demo.security.JwtTokenProvider;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Bean
    public SecretKey jwtSecretKey() {
        // ✅ 256-bit secure key (NO WeakKeyException)
        return Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    }

    @Bean
    public JwtTokenProvider jwtTokenProvider(SecretKey key) {
        return new JwtTokenProvider(key);
    }
}
