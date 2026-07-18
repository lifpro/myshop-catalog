package com.myshop.catalog_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {

    @RequestMapping("/hello")
    public String hello() {
        return "Bienvenue sur le service catalogue";
    }
}
