package com.example.country_service.service;

import com.example.country_service.model.Country;
import com.example.country_service.repository.CountryRepository;
import com.example.country_service.service.exception.CountryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public Country findCountryByCode(String code) {
        Country country = countryRepository.findByCode(code);
        if (country == null) {
            throw new CountryNotFoundException("Country not found: " + code);
        }
        return country;
    }
}
