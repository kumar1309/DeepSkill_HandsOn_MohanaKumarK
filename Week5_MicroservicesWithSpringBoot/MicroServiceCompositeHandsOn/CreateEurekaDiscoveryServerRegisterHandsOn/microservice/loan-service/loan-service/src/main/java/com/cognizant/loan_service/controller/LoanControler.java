package com.cognizant.loan_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/loan")
public class LoanControler {
    @GetMapping("/info")
    public String getLoanInfo() {
        return "Loan Service is up and running!";
    }
}
