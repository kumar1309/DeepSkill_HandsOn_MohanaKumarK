package com.example.country_service.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.country_service.service.CountryService;
import com.example.country_service.service.exception.CountryNotFoundException;
import com.example.country_service.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
        return ResponseEntity.ok("Country added successfully");
    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        Country country = countryService.findCountryByCode(code);
        return ResponseEntity.ok(country);
    }
}