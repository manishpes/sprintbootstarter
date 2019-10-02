package com.manish.controllers;

import com.manish.dao.UserDao;
import com.manish.dao.UserDaoImpl;
import com.manish.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserDao userDao;
    @PostMapping("/adduser")
    public String AddUser(@RequestBody User user){
        userDao.insertUser(user);
        return "User Added Successfully.";
    }


    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getUser(){
        List users = userDao.getUsers();
        return users;
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser(@RequestParam  int id){
        User user = userDao.getUser(id);
        return user;
    }

}

