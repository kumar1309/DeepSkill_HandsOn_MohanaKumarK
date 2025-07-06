package com.example.country_service;
import com.example.country_service.model.Country;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.country_service.repository.CountryRepository;

import com.example.country_service.service.CountryService;

import javax.swing.Spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountryServiceApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(CountryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(CountryService countryService) {
		return args -> {
			
			Country country = new Country("CO", "Cognizant");
			countryService.addCountry(country);
			Country retrievedCountry = countryService.findCountryByCode("CO");
			System.out.println("Country added: " + country);
		};
	}


}
