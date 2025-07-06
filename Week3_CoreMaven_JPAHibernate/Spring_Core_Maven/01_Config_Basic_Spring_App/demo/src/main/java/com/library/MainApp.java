package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {
    public static void main(String[] args) {
        // Create the application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from the context
        BookService bookService = context.getBean(BookService.class);

        // Use the BookService to add a book
        bookService.addBook("Learning Spring with me", "Mohana Kumar K");
    }
}