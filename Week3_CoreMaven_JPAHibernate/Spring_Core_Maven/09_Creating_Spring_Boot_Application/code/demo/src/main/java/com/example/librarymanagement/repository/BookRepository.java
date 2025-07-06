package com.example.librarymanagement.repository;
import com.example.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long> {
    // This interface will automatically provide CRUD operations for the Book entity
    // No need to define any methods here, JpaRepository provides all necessary methods
}