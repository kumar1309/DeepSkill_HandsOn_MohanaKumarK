package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggingExample{
    public static final Logger log= LoggerFactory.getLogger(LoggingExample.class);
    public static void main(String[] args) {
        log.info("This is an info message");
        log.warn("This is a warning message");
        log.error("This is an error message");
    }
}