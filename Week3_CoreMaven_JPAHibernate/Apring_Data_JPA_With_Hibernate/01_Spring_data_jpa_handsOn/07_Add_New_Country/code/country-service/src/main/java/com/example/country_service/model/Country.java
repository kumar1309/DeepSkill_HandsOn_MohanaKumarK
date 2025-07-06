package com.example.country_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Country {

    @Id
    @Column(name = "co_code")  // 👈 maps to `co_code` column
    private String code;

    @Column(name = "co_name")  // 👈 maps to `co_name` column
    private String name;

    public Country() {}

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and setters...
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
