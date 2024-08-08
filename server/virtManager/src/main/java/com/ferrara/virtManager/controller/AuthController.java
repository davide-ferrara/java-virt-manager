package com.ferrara.virtManager.controller;

import com.ferrara.virtManager.classes.LoginResponse;
import com.ferrara.virtManager.entity.User;
import com.ferrara.virtManager.repository.UserRepository;
import com.ferrara.virtManager.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody User user) {
        long sessionToken = 0;
        User auth = userService.authenticate(user.getUserName(), user.getPassword());

        if (auth == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        sessionToken = auth.getId();
        System.out.println("Session toekn = " + sessionToken);

        LoginResponse response = new LoginResponse(sessionToken);
        System.out.println(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/auth/logout")
    public void logout() {
        System.err.println("TODO");
    }
}
