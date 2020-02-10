package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.User;
import com.controlnet.controlnetrestapi.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/insert")
    public ResponseEntity insertUser(@RequestBody User user) {
       return userDetailsService.insertNewUser(user);
    }
}
