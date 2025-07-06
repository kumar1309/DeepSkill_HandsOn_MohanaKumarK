package com.example.hibernate.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id; // Your attribute
    @Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Employee> employeeList;

	// Getters & Setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public List<Employee> getEmployeeList() { return employeeList; }
	public void setEmployeeList(List<Employee> employeeList) { this.employeeList = employeeList; }
}
