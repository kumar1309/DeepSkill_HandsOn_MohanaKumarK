package com.example.hibernate;

import com.example.hibernate.model.Employee;
import com.example.hibernate.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateApplication.class);

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testGetAllPermanentEmployees();
		testGetAllEmployeesNative();
		testGetAverageSalary();
	}

	private void testGetAllPermanentEmployees() {
		LOGGER.info("Start: getAllPermanentEmployees");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		employees.forEach(e -> {
			LOGGER.info("Employee: {}", e.getName());
			LOGGER.info("Department: {}", e.getDepartment().getName());
			LOGGER.info("Skills: {}", e.getSkillList());
		});
		LOGGER.info("End");
	}

	private void testGetAllEmployeesNative() {
		LOGGER.info("Start: getAllEmployeesNative");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		employees.forEach(e -> LOGGER.info("Employee: {}", e.getName()));
		LOGGER.info("End");
	}

	private void testGetAverageSalary() {
		LOGGER.info("Start: getAverageSalary");
		double avgSalary = employeeService.getAverageSalary(1);
		LOGGER.info("Average Salary for Department 1: {}", avgSalary);
		LOGGER.info("End");
	}
}
