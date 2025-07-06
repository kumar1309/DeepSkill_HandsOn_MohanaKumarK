package com.cognizant.ormlearn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CountryRepository extends JpaRepository<com.cognizant.ormlearn.model.Country, String> {
    // This interface will automatically provide CRUD operations for the Country entity
    // No additional methods are needed unless custom queries are required
}    

