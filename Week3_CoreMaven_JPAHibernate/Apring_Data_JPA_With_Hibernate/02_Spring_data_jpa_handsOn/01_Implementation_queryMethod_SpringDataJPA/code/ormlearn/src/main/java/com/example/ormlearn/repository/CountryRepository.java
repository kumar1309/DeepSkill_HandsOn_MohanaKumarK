package com.example.ormlearn.repository;
import org.springframework.stereotype.Repository;
import com.example.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    // Custom query method to find countries by name
    List<Country> findByName(String name);
    
    // Custom query method to find countries by code
    List<Country> findByCode(String code);
    
    // Custom query method to find countries by name containing a specific string
    List<Country> findByNameContaining(String namePart);
}
