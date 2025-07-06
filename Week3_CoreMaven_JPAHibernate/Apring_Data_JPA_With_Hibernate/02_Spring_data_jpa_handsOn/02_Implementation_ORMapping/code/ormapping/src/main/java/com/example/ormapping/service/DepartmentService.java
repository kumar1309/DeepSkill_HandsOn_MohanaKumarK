package com.example.ormapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ormapping.model.Department;
import com.example.ormapping.repository.DepartmentRepository;
import jakarta.transaction.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department get(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Department department) {
        departmentRepository.save(department);
    }
}
