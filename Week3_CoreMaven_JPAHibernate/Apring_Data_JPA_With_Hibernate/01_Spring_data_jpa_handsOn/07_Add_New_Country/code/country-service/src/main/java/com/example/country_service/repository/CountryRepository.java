package com.example.country_service.repository;

import com.example.country_service.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
 Country findByCode(String code);
}
