package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBook(String bookName, String authorName) {
        // Logic to add book
        System.out.println("Adding book: " + bookName + " by " + authorName);
        bookRepository.saveBook(bookName, authorName);
    }
    

}
