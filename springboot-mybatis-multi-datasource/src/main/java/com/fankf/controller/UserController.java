package com.fankf.controller;

import com.fankf.entity.User;
import com.fankf.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * fankunfeng
 * 2020-09-02 14:06
 */
@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.queryById(id);
    }
}
