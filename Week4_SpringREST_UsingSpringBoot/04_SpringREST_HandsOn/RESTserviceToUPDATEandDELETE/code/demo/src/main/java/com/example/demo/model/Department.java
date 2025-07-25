package com.example.demo.model;

import jakarta.validation.constraints.*;

public class Department {
    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 1, max = 30)
    private String name;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
