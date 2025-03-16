package com.coding.cruddemo.dao;

import com.coding.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> typedQuery =
                this.entityManager.createQuery("FROM Employee", this.getEntityClass());
        List<Employee> employees = typedQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = this.entityManager.find(this.getEntityClass(), id);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee updatedEmployee = this.entityManager.merge(employee);

        return updatedEmployee;
    }

    @Override
    public void delete(int id) {
        Employee emp = this.findById(id);
        if(emp != null) {
            this.entityManager.remove(emp);
        }
    }

    private Class<Employee> getEntityClass() {
        return Employee.class;
    }

}
