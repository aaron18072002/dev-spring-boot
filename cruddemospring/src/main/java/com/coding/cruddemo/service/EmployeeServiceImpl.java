package com.coding.cruddemo.service;

import com.coding.cruddemo.dao.EmployeeDAO;
import com.coding.cruddemo.entity.Employee;
import com.coding.cruddemo.repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO, EmployeeRepo employeeRepo) {
        this.employeeDAO = employeeDAO;
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
         List<Employee> employees = this.employeeRepo.findAll();
         return employees;
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = this.employeeRepo.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw  new RuntimeException("Employee not found with id - " + id);
        }
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.employeeDAO.delete(id);
    }

}
