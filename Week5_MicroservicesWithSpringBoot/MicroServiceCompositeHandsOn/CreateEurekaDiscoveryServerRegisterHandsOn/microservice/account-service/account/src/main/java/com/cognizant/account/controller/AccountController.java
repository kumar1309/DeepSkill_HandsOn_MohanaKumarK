package com.cognizant.account.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/info")
public String getAccountInfo() {
    return "Account Service is running!";
    }
}
