package com.coding.cruddemo.repository;

import com.coding.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

//    Optional<Employee> findById(int id);

}
