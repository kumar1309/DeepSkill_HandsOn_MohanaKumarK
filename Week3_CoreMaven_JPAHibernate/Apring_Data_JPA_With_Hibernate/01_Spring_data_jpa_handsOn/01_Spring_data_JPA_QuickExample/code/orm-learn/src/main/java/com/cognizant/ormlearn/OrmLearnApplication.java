package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger logger = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		logger.info("Application started successfully");
		
		testCountryService();
	}
	private static void testCountryService() {
		List<Country> countries = countryService.getAllCountries();
		if (countries.isEmpty()) {
			logger.info("No countries found in the database.");
		} else {
			logger.info("Countries found: ");
			for (Country country : countries) {
				logger.info(country.toString());
			}
		}
	}

}
