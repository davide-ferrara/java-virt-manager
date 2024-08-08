package com.ferrara.virtManager.controller;

import com.ferrara.virtManager.entity.User;
import com.ferrara.virtManager.repository.UserRepository;
import com.ferrara.virtManager.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/userById")
    public List<User> getUserById(@RequestParam(name = "id") long userID) {
        Optional<User> user = userRepository.findById(userID);

        return List.of(user.get());

    }
}