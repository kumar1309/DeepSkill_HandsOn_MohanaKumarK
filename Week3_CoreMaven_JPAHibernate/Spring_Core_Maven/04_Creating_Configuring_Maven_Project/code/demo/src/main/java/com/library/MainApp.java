package com.library;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.saveBook("Java made simple ", "Mohan");
        
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.saveBook("Java for CTS", "Kumar");
    }
    
}
