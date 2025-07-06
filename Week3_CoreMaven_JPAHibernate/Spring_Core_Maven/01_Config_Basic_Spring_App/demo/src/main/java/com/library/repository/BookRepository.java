package com.library.repository;
public class BookRepository {
   
    public void saveBook(String book_name, String author) {
        // Logic to save book to the database
        System.out.println("Book saved: " + book_name + " by " + author);
    }
}