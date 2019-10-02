package com.manish.controllers;

import com.manish.dao.UserDao;
import com.manish.dao.UserDaoImpl;
import com.manish.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDaoImpl userDao;
    @PostMapping("/adduser")
    public String AddUser(@RequestBody User user){
        logger.debug("Adding user with user name {} ", user.getfName());
        userDao.insertUser(user);
        return "User Added Successfully.";
    }


    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getUser(){
        logger.debug("Getting All users");
        List users = userDao.getUsers();
        logger.debug("Number of users found {} ",users.size());
        return users;
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser(@RequestParam  int id){
        User user = userDao.getUser(id);
        return user;
    }

}

