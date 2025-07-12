package com.cognizant.spring_learn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.info("Inside Country Constructor");
    }

    public String getCode() {
        LOGGER.info("getCode called");
        return code;
    }

    public void setCode(String code) {
        LOGGER.info("setCode called");
        this.code = code;
    }

    public String getName() {
        LOGGER.info("getName called");
        return name;
    }

    public void setName(String name) {
        LOGGER.info("setName called");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}';
    }
}
