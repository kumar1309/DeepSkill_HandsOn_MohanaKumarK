package com.example.service;

public class BookService {

    public void issueBook(String bookName) {
        System.out.println("Issuing book: " + bookName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void returnBook(String bookName) {
        System.out.println("Returning book: " + bookName);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
