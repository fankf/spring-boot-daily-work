package com.fankf.controller;

import com.fankf.entity.User;
import com.fankf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("one/{id}")
    public User selectOne(@PathVariable Integer id){
        return userService.selectOne(id);
    }
}
