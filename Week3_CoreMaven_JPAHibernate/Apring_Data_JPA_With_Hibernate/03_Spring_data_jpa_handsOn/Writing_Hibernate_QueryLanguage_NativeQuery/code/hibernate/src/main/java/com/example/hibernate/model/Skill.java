package com.example.hibernate.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "sk_id")
    private int id; // Your attribute
    @Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "skillList")
	private List<Employee> employees;

	// Getters & Setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public List<Employee> getEmployees() { return employees; }
	public void setEmployees(List<Employee> employees) { this.employees = employees; }
}
