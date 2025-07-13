package com.example.demo.dao;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Skill;

import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> employeeList = new ArrayList<>();
    static {
    Employee e = new Employee();
    e.setId(1L); // give ID for update/delete
    e.setName("Mohan"); // valid name
    e.setSalary(5000.0);   // valid salary
    e.setPermanent(true);  // valid flag

    try {
        e.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/1990"));
    } catch (ParseException ex) {
        ex.printStackTrace();
    }

    Department dept = new Department();
    dept.setId(1L);
    dept.setName("HR");
    e.setDepartment(dept);

    Skill skill = new Skill();
    skill.setId(1L);
    skill.setName("Java");

    List<Skill> skills = new ArrayList<>();
    skills.add(skill);
    e.setSkills(skills);

    employeeList.add(e);
}


    public void updateEmployee(Employee emp) {
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(emp.getId())) {
                employeeList.set(i, emp);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + emp.getId());
        }
    }

    public void deleteEmployee(Long id) {
        boolean removed = employeeList.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
