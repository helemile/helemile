package com.shumile.druid_demo.controller;

import com.shumile.druid_demo.User;
import com.shumile.druid_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers(){
           return userService.listData();
    }
    @GetMapping("/add")
    public int addUser(@RequestBody  User user){
        return userService.addUser(user);
    }

}
