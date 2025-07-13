package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void updateEmployee(Employee emp) {
        employeeDao.updateEmployee(emp);
    }

    public void deleteEmployee(Long id) {
        employeeDao.deleteEmployee(id);
    }
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
