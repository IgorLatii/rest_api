package com.example.restapi.service;

import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /*public Optional<User> getUserById(String userName) {
        return userRepository.findById(userName);
    }*/

    public Optional<User> authenticateUser(String userName, String password) {
        Optional<User> userOptional = userRepository.findById(userName);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Checking passwords
            if (user.getPassword().equals(password)) {
                return Optional.of(user); // Success
            }
        }
        return Optional.empty();
    }
}
