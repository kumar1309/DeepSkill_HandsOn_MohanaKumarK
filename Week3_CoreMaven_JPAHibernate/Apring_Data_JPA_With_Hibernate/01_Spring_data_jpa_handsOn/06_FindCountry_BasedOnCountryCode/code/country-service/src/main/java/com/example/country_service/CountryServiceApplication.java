package com.example.country_service;
import com.example.country_service.model.Country;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.country_service.repository.CountryRepository;
import com.example.country_service.service.exception.CountryNotFoundException;
import com.example.country_service.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountryServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(CountryServiceApplication.class);
	private static CountryService countryService;


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CountryServiceApplication.class, args);
		countryService = context.getBean(CountryService.class);
		logger.info("Country Service Application started successfully.");
		getCountryByCode();
	}
	private static void getCountryByCode() {
		try {
			Country country = countryService.findCountryByCode("IN");
			logger.info("Country found: " + country);
		} catch (CountryNotFoundException e) {
			logger.error("Error: " + e.getMessage());
		}
	}


}
