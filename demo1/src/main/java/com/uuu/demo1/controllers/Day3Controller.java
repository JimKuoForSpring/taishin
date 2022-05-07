package com.uuu.demo1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day3Controller {
    @GetMapping(value = "/hello", name = "default rest controller1")
    public String ping() {
        return "pong";
    }
}
