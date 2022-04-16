package com.uuu.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String home321(Model model) {
        model.addAttribute("message","Hi, I am Jim");
        return "home";
    }
}