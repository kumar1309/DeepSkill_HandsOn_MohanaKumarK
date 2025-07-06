package com.example.ormapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.ormapping.model.Department;
import com.example.ormapping.model.Skill;
import com.example.ormapping.model.Employee;
import com.example.ormapping.service.DepartmentService;
import com.example.ormapping.service.EmployeeService;
import com.example.ormapping.service.SkillService;

import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        var context = SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetEmployee();
        testGetDepartment();
        testAddEmployee();
        testAddSkillToEmployee();
    }

    private static void testGetEmployee() {
        Employee emp = employeeService.get(1);
        System.out.println(emp);
        System.out.println("Dept: " + emp.getDepartment());
        System.out.println("Skills: " + emp.getSkillList());
    }

    private static void testGetDepartment() {
        Department dept = departmentService.get(1);
        System.out.println(dept);
        System.out.println("Employees: " + dept.getEmployeeList());
    }

    private static void testAddEmployee() {
        Employee emp = new Employee();
        emp.setEm_name("Test Emp");
        emp.setEm_salary(70000);
        emp.setEm_permanent(true);
        emp.setEm_date_of_birth(new java.util.Date());

        Department dept = departmentService.get(1);
        emp.setDepartment(dept);

        employeeService.save(emp);
        System.out.println("Added: " + emp);
    }

    private static void testAddSkillToEmployee() {
        Employee emp = employeeService.get(1);
        Skill skill = skillService.get(3);

        Set<Skill> skills = emp.getSkillList();
        skills.add(skill);
        emp.setSkillList(skills);

        employeeService.save(emp);
        System.out.println("Added Skill: " + emp);
    }

}
