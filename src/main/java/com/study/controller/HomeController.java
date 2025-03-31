package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/sub")
    public String sub(Model model) {
        model.addAttribute("data", "hello!!");
        return "sub";
    }
}
