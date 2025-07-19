package com.cognizant.loan.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class LoanController {
    @GetMapping("/loan/{number}")
    public Map<String, String> getLoanDetails(@PathVariable("number") String number) {
        return Map.of("number",number , "type", "Car",
                     "loan", "40000", "emi", "3258","tenure", "18");
    }
    
}
