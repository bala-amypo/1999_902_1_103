// // // package com.example.demo.service.impl;
// // // import com.example.demo.service.UserService;
// // // public class UserServiceImpl implements UserService{
    
// // // }

// // package com.example.demo.serviceimpl;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Service;

// // import com.example.demo.model.User;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.UserService;

// // @Service
// // public class UserServiceImpl implements UserService {

// //     @Autowired
// //     private UserRepository userRepository;

// //     @Override
    
// //     public User registerUser(User user) {
// //         return userRepository.save(user);
// //     }

// //     @Override
// //     public User loginUser(String username, String password) {

// //         User user = userRepository.findByUsername(username);

// //         if (user != null && user.getPassword().equals(password)) {
// //             return user;
// //         }
// //         return null;
// //     }
// // }


// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// @Service
// @Transactional
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     public UserServiceImpl(UserRepository userRepository,
//                            PasswordEncoder passwordEncoder) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Override
//     public User register(User user) {
//         if (userRepository.existsByEmail(user.getEmail())) {
//             throw new IllegalArgumentException("exists");
//         }
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         if (user.getRole() == null) {
//             user.setRole("ANALYST");
//         }
//         return userRepository.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//     }
// }

@Override
public User registerUser(User user) {
    if (userRepository.existsByEmail(user.getEmail())) {
        throw new IllegalArgumentException("exists");
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    if (user.getRole() == null) {
        user.setRole("ANALYST");
    }
    return userRepository.save(user);
}
