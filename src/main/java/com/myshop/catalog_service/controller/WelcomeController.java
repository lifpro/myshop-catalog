package com.myshop.catalog_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {

    @GetMapping("/hello")
    public String hello() {
        return "Bienvenue sur le service catalogue";
    }

    @GetMapping("/version")
    public String version() {
        return "Service catalogue verions : 1.0.0";
    }
}
