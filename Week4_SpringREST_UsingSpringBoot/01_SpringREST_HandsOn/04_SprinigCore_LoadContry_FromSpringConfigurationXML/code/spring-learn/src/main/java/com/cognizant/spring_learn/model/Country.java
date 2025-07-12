package com.cognizant.spring_learn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger logger = LoggerFactory.getLogger(Country.class);

    private String name;
    private String code;

    public Country() {
        logger.info("Country constructor called");
    }

    public String getCode() {
        logger.info("getCode called");
        return code;
    }

    public void setCode(String code) {
        logger.info("setCode called with value: " + code);
        this.code = code;
    }

    public String getName() {
        logger.info("getName called");
        return name;
    }

    public void setName(String name) {
        logger.info("setName called with value: " + name);
        this.name = name;
    }

    @Override
    public String toString() {
        logger.info("toString called");
        return "Country [name=" + name + ", code=" + code + "]";
    }
}
