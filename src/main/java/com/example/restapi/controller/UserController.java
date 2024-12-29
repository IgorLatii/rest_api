package com.example.restapi.controller;

import com.example.restapi.model.User;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users_adm")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/{name}")
    public ResponseEntity<String> authenticateUser(@PathVariable String name, @RequestParam String password) {
        //System.out.println("Received key_word: " + name);
        //System.out.println("Received key_word: " + password);
        // Call auth method
        Optional<User> user = userService.authenticateUser(name, password);

        if (user.isPresent()) {
            return ResponseEntity.ok("Authorization successful! Welcome, " + user.get().getUserName());
        } else {
            return ResponseEntity.status(401).body("Authorization failed: invalid username or password");
        }
    }
}
