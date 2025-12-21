// package com.example.demo.service;
// public interface UserService{
//     User register(User user);
//     User findByEmail(String email);
// }

package com.example.shiftscheduler.service;

import com.example.shiftscheduler.entity.User;

public interface UserService {

    User registerUser(User user);

    User loginUser(String username, String password);
}
