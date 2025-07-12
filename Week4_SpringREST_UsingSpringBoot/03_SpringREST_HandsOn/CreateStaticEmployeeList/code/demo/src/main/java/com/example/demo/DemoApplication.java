package com.example.demo;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
        List<Employee> employees = dao.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }
	}

}
