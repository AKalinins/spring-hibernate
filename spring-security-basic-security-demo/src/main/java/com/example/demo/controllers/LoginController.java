package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        //return "custom-login-form";
        return "fancy-login-form-with-bootstrap";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "access-denied-page";
    }
}
