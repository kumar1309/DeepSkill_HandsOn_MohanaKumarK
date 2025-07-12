package com.example.demo.dao;
import com.example.demo.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;

public class DepartmentDao {
    private static ArrayList<Department> departmentList;
    public DepartmentDao() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        departmentList = (ArrayList<Department>) context.getBean("department_list");
        context.close();
    }
    public ArrayList<Department> getAllDepartments() {
        return departmentList;
    }
    
}
