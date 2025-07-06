package com.library.service;
import com.library.repository.BookRepository;
import com.library.model.Book;
public class BookService {
    private BookRepository bookRepository;
    private String libraryName;
    public BookService(String libraryName){
        this.libraryName = libraryName;
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void displayBookDetails() {
        Book book = bookRepository.getBook();
        System.out.println("Library Name: " + libraryName);
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Book Author: " + book.getAuthor());
    }
    
    
}
