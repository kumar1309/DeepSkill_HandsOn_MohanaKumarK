package com.example.ormapping.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int em_id;

    private String em_name;

    private double em_salary;

    private boolean em_permanent;

    @Temporal(TemporalType.DATE)
    private Date em_date_of_birth;

    @ManyToOne
    @JoinColumn(name = "em_dp_id")
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "employee_skill",
        joinColumns = @JoinColumn(name = "es_em_id"),
        inverseJoinColumns = @JoinColumn(name = "es_sk_id")
    )
    private Set<Skill> skillList;

    // ====== Getters & Setters ======

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public String getEm_name() {
        return em_name;
    }

    public void setEm_name(String em_name) {
        this.em_name = em_name;
    }

    public double getEm_salary() {
        return em_salary;
    }

    public void setEm_salary(double em_salary) {
        this.em_salary = em_salary;
    }

    public boolean isEm_permanent() {
        return em_permanent;
    }

    public void setEm_permanent(boolean em_permanent) {
        this.em_permanent = em_permanent;
    }

    public Date getEm_date_of_birth() {
        return em_date_of_birth;
    }

    public void setEm_date_of_birth(Date em_date_of_birth) {
        this.em_date_of_birth = em_date_of_birth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Employee [id=" + em_id + ", name=" + em_name + "]";
    }
}
