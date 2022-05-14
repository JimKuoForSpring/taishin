package com.example.demo2.demo2.controller;

import com.example.demo2.demo2.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @Autowired
    Message message;
    @RequestMapping("/welcome")
    Message bar() {
        return message;
    }
}
