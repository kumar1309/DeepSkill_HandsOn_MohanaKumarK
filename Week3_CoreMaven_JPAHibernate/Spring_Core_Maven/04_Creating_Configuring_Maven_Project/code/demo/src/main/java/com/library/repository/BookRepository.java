package com.library.repository;


public class BookRepository {
    public void saveBook(String book_name,String author_name) {
        System.out.println("Book saved: " + book_name + " by " + author_name);
    }
    
}
