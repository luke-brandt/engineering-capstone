package com.skylinecoffee.springbootapp.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginScreenController {
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
}
