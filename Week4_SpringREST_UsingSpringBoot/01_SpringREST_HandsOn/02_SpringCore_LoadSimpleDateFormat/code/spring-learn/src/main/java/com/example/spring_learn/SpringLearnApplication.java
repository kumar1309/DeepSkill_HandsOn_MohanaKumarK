package com.example.spring_learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext; // ✅ Correct import
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        displayDate();
    }

    public static void displayDate() {
    
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

       
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        try {
       
            Date date = format.parse("31/12/2018");

           
            System.out.println("Parsed Date: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
