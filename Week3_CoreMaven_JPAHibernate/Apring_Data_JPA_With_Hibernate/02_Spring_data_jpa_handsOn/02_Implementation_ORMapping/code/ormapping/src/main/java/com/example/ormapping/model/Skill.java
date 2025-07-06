package com.example.ormapping.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sk_id;

    private String sk_name;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;

    // ====== Getters & Setters ======

    public int getSk_id() {
        return sk_id;
    }

    public void setSk_id(int sk_id) {
        this.sk_id = sk_id;
    }

    public String getSk_name() {
        return sk_name;
    }

    public void setSk_name(String sk_name) {
        this.sk_name = sk_name;
    }

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Skill [id=" + sk_id + ", name=" + sk_name + "]";
    }
}
