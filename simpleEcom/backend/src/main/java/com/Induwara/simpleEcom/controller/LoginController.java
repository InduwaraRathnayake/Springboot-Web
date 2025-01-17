package com.Induwara.simpleEcom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//if we use @Controller, we return the page to the frontend
@RestController
@RequestMapping("/api")
public class LoginController {
    
    @RequestMapping("/login")
    public String login() {
        return "This is login page"; //return a string for frontend
    }

}

