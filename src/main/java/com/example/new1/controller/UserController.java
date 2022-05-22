package com.example.new1.controller;

import com.example.new1.model.User;
import com.example.new1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    

}
