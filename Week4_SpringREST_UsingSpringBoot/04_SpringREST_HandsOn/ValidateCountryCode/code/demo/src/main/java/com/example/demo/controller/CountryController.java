package com.example.demo.controller;

import com.example.demo.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        logger.info("Received country: {}", country);
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Country>> violations = validator.validate(country);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Country> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sb.toString());
        }
        
        // Here you would typically save the country to a database
        return country; // For demonstration, we return the same country object
    }
    
}
