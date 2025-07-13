package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;

public class Employee {

    @NotNull(message = "ID must not be null")
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 1, max = 30, message = "Name must be 1 to 30 characters")
    private String name;

    @NotNull(message = "Salary must not be null")
    @Min(value = 0, message = "Salary must be zero or positive")
    private Double salary;

    @NotNull(message = "Permanent must not be null")
    private Boolean permanent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @Valid
    @NotNull
    private Department department;

    @Valid
    @NotNull
    private List<Skill> skills;

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
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Boolean getPermanent() {
        return permanent;
    }
    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public List<Skill> getSkills() {
        return skills;
    }
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", permanent=" + permanent +
                ", dateOfBirth=" + dateOfBirth +
                ", department=" + department +
                ", skills=" + skills +
                '}';
    }
}
