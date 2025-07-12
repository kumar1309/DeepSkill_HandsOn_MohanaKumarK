package com.example.demo.service;


import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.Department;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class DepartmentService {
    private final DepartmentDao departmentDao;

    public DepartmentService() {
        this.departmentDao = new DepartmentDao();
    }

    public ArrayList<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
    
}
