// package com.example.demo.controller;
// public class AuthController{
    
// }

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User loggedUser = userService.loginUser(
                user.getUsername(), 
                user.getPassword()
        );

        if (loggedUser != null) {
            return "Login successful. Role: " + loggedUser.getRole();
        } else {
            return "Invalid username or password";
        }
    }
}
