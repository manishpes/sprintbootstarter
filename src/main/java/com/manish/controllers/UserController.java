package com.manish.controllers;

import com.manish.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserController {

    @RequestMapping("/getuser")
    public User getUser(){
        User user = new User();
        return user;
    }
}

