package com.example.ormlearn;
import com.example.ormlearn.model.Country;
import com.example.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class OrmlearnApplication implements CommandLineRunner {
	@Autowired
	private CountryRepository countryRepository;


	public static void main(String[] args) {
		SpringApplication.run(OrmlearnApplication.class, args);
	}
	public void run(String... args) throws Exception {
		// Create a new country
		Country country = new Country();
		country.setCode("IN");
		country.setName("India");

		// Save the country to the database
		countryRepository.save(country);

		// Retrieve all countries
		List<Country> countries = countryRepository.findAll();
		System.out.println("Countries in the database:");
		for (Country c : countries) {
			System.out.println(c);
		}

		// Find countries by name
		List<Country> indiaCountries = countryRepository.findByName("India");
		System.out.println("Countries with name 'India': " + indiaCountries);

		// Find countries by code
		List<Country> inCountries = countryRepository.findByCode("IN");
		System.out.println("Countries with code 'IN': " + inCountries);

		// Find countries by name containing a specific string
		List<Country> containingInd = countryRepository.findByNameContaining("Ind");
		System.out.println("Countries with name containing 'Ind': " + containingInd);
	} 

}
