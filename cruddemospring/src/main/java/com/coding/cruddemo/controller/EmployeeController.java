package com.coding.cruddemo.controller;

import com.coding.cruddemo.entity.Employee;
import com.coding.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getById(@PathVariable String employeeId) {
        Integer id = Integer.parseInt(employeeId);
        Employee employee = this.employeeService.findById(id);
        if(employee == null) {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }

        return employee;
    }

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        employee.setEmployeeId(null);
        Employee savedEmployee = this.employeeService.save(employee);
        return savedEmployee;
    }

    @PutMapping("/employee/{employeeId}")
    public Employee update(@PathVariable Integer employeeId, @RequestBody Employee employee) {
        employee.setEmployeeId(employeeId);
        Employee savedEmployee = this.employeeService.save(employee);
        return savedEmployee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String delete(@PathVariable Integer employeeId) {
        Employee employee = this.employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }

        return "Delete successful";
    }

}
