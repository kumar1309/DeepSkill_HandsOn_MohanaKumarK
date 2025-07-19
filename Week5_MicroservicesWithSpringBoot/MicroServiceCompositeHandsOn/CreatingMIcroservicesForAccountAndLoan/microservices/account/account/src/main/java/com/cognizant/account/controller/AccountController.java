package com.cognizant.account.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
@RestController
public class AccountController {
    
    @GetMapping("/accounts/{number}")
    public Map<String, String> getAccountDetails(@PathVariable String number) {
        // Simulating account details retrieval
        return Map.of("id", number, "name", "MohanaKumar", "type","savings","balance", "1000");
    }
}