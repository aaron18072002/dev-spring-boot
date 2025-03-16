package com.coding.cruddemo.dao;

import com.coding.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer studentId);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    int deleteById(Integer studentId);

    int deleteAll();

}
