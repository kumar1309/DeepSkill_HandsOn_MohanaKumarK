package com.example.demo.service;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;
    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
    }
    @Transactional(readOnly = true)
    public ArrayList<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
    
}
