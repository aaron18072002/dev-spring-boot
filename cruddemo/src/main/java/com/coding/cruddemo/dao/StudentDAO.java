package com.coding.cruddemo.dao;

import com.coding.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer studentId);

}
