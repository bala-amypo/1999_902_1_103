// package com.example.demo.service.impl;
// import com.example.demo.service.UserService;
// public class UserServiceImpl implements UserService{
    
// }

package com.example.shiftscheduler.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shiftscheduler.entity.User;
import com.example.shiftscheduler.repository.UserRepository;
import com.example.shiftscheduler.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {

        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
