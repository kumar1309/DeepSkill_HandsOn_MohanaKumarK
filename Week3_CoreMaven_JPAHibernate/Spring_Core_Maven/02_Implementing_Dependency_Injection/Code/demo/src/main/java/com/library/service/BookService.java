package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBook(String bookName, String author) {
        // Logic to add a book using bookRepository
        System.out.println("Adding book: " + bookName+ " by " + author);
        // bookRepository.save(bookName); // Hypothetical save method
        bookRepository.saveBook(bookName, author);

    }
    
}
