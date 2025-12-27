package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Endpoints")
public class AuthController {
    
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    
    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider, 
                         PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/register")
    @Operation(summary = "Register new user")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }
    
    @PostMapping("/login")
@Operation(summary = "Login user")
public ResponseEntity<?> login(@RequestBody AuthRequest request) {

    User user = userService.findByEmail(request.getEmail());

    // User not found
    if (user == null) {
        return ResponseEntity
                .status(401)
                .body(Map.of(
                        "message", "User not found",
                        "status", 401
                ));
    }

    // Password mismatch
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        return ResponseEntity
                .status(401)
                .body(Map.of(
                        "message", "Invalid email or password",
                        "status", 401
                ));
    }

    // Success
    String token = jwtTokenProvider.generateToken(user);
    return ResponseEntity.ok(
            new AuthResponse(token, user.getEmail(), user.getRole())
    );
}

}