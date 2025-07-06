package com.example.hibernate.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "em_id")
    private int id;  // Your attribute
     @Column(name = "name")
	private String name;
    @Column(name = "permanent")
	private boolean permanent;
     @Column(name = "salary")
	private double salary;

	@ManyToOne
	@JoinColumn(name = "em_dp_id")
	private Department department;

	@ManyToMany
	@JoinTable(
		name = "employee_skill",
		joinColumns = @JoinColumn(name = "es_em_id"),
		inverseJoinColumns = @JoinColumn(name = "es_sk_id")
	)
	private List<Skill> skillList;

	// Getters & Setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public boolean isPermanent() { return permanent; }
	public void setPermanent(boolean permanent) { this.permanent = permanent; }

	public double getSalary() { return salary; }
	public void setSalary(double salary) { this.salary = salary; }

	public Department getDepartment() { return department; }
	public void setDepartment(Department department) { this.department = department; }

	public List<Skill> getSkillList() { return skillList; }
	public void setSkillList(List<Skill> skillList) { this.skillList = skillList; }
}
