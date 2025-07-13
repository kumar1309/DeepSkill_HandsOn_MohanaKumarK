package com.example.demo.model;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class Country{
    @NotNull
    @Size(min = 2, max = 3, message = "Country code must be between 2 and 3 characters")
    private String code;
    private String name;
    public Country() {
    }
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}