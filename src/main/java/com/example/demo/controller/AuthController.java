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
public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

    // 1️⃣ Check user existence
    User user = userService.findByEmail(request.getEmail());
    if (user == null) {
        return ResponseEntity.status(401)
                .body(new AuthResponse(null, "User not found", null));
    }

    // 2️⃣ Check password
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        return ResponseEntity.status(401)
                .body(new AuthResponse(null, "Invalid password", null));
    }

    // 3️⃣ Generate token
    String token = jwtTokenProvider.generateToken(user);

    return ResponseEntity.ok(
            new AuthResponse(token, user.getEmail(), user.getRole())
    );
}

}