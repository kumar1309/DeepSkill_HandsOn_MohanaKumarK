package com.cognizant.spring_learn.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger logger = LoggerFactory.getLogger(Country.class);
    private String name;
    private String code;
    public Country() {
        logger.info("Country object created");
    }
    public String getName() {
        logger.info("Getting country name: {}", name);
        return name;
    }
    public void setName(String name) {
        this.name = name;
        logger.info("Country name set to: {}", name);
    }
    public String getCode() {
        logger.info("Getting country code: {}", code);
        return code;
    }
    public void setCode(String code) {
        this.code = code;
        logger.info("Country code set to: {}", code);
    }
    @Override
    public String toString() {
        logger.info("Converting Country to String");
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }


    
}
