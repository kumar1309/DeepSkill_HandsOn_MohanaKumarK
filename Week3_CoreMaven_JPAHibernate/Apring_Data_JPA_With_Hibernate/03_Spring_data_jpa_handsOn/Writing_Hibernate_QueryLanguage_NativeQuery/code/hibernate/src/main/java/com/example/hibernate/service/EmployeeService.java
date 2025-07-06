package com.example.hibernate.service;

import com.example.hibernate.model.Employee;
import com.example.hibernate.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllPermanentEmployees() {
		return employeeRepository.getAllPermanentEmployees();
	}

	public List<Employee> getAllEmployeesNative() {
		return employeeRepository.getAllEmployeesNative();
	}

	public double getAverageSalary(int id) {
    Double avg = employeeRepository.getAverageSalary(id);
    return avg != null ? avg : 0.0; // Handle null to avoid crash
}

}
