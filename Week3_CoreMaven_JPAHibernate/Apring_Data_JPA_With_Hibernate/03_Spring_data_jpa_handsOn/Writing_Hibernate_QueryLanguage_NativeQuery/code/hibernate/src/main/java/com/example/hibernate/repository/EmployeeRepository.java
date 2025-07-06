package com.example.hibernate.repository;

import com.example.hibernate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();

    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    Double getAverageSalary(@Param("id") int id); // ✅ Use Double, not double
}
