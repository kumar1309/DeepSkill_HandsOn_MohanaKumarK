package com.cognizant.spring_learn.controller;
import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@RestController
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/country")
    public Country getCountry() {
        logger.info("Inside getCountry method");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean(Country.class);
        logger.info("Country: {}", country);
        return country;
    }
}