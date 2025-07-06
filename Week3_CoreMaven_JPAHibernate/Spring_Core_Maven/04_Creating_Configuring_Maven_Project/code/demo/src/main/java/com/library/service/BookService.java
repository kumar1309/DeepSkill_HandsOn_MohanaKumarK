package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void saveBook(String book_name, String author_name) {
        bookRepository.saveBook(book_name, author_name);
        System.out.println("BookService: Book saved successfully.With details: " + book_name + " by " + author_name);
    }
    
}
