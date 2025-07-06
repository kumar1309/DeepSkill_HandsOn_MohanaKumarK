package com.library.service;
import com.library.repository.BookRepository;
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName, String author) {
        // Logic to validate book details can be added here
        System.out.println("Adding book: " + bookName + " by " + author);
        bookRepository.saveBook(bookName, author);
    }
}