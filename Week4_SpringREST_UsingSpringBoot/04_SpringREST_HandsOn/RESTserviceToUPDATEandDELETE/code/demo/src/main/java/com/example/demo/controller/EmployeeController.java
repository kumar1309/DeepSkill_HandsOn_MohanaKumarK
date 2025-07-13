package com.example.demo.controller;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        service.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
     @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
    
}
