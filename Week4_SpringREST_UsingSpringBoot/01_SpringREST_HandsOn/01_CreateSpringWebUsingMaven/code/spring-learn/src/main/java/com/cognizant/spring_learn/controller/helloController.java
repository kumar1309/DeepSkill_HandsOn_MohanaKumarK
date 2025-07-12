package com.cognizant.spring_learn.controller;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class helloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello, Spring Boot!";
    }
}
