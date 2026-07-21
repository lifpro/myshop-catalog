package com.myshop.catalog_service.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@Slf4j
public class WelcomeController {

    @GetMapping("/hello")
    public String hello() {
        log.info("Log: Bienvenue sur le service catalogue");
        return "Bienvenue sur le service catalogue";
    }

    @GetMapping("/version")
    public String version() {
        return "Service catalogue verions : 1.0.0";
    }
}
