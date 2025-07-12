package com.cognizant.spring_learn;
import com.cognizant.spring_learn.model.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        logger.debug("Starting SpringLearnApplication");
        displayCountryInfo();
        logger.debug("Ending SpringLearnApplication");
        
    }

    public static void displayCountryInfo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");

        Country countryUS = context.getBean("countryUS", Country.class);
		Country countryDE = context.getBean("countryDE", Country.class);
		Country countryIN = context.getBean("countryIN", Country.class);
		Country countryJP = context.getBean("countryJP", Country.class);
		logger.info("Country : {}", countryUS.toString());
		logger.info("Country : {}", countryDE.toString());
		logger.info("Country : {}", countryIN.toString());
		logger.info("Country : {}", countryJP.toString());
    }
}
