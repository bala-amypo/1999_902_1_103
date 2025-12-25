package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public boolean validateToken(String token) {
        return false; // Mock implementation
    }
    
    public String getEmailFromToken(String token) {
        return null; // Mock implementation
    }
}