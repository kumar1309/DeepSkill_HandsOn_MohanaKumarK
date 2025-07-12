package com.example.demo.dao;
import com.example.demo.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
public class EmployeeDao {
    public static ArrayList<Employee> Employee_list;
    public EmployeeDao(){
        ApplicationContext context= new ClassPathXmlApplicationContext("employee.xml");
        Employee_list = (ArrayList<Employee>) context.getBean("employeeList");
    }
    public ArrayList<Employee> getAllEmployees(){
        return Employee_list;
    }
    
}
