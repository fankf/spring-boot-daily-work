package com.fankf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/helloworld")
    public String helloworld() {
        return "hello world !";
    }
}
