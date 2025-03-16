package com.coding.cruddemo.dao;

import com.coding.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student findById(Integer studentId) {
        return this.entityManager.find(this.getEntityClass(), studentId);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> typedQuery =
                this.entityManager.createQuery("FROM Student AS S ORDER BY S.lastName DESC", this.getEntityClass());

        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> typedQuery =
                this.entityManager.createQuery("FROM Student AS S WHERE S.lastName = : lastName", this.getEntityClass());
        typedQuery.setParameter("lastName", lastName);

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public int deleteById(Integer studentId) {
         Query typedQuery =
                 this.entityManager.createQuery("DELETE FROM Student AS S WHERE  S.studentId = :studentId");
         typedQuery.setParameter("studentId", studentId);

         return typedQuery.executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAll() {
        Query query = this.entityManager
                .createQuery("DELETE FROM Student ");
        return query.executeUpdate();
    }

    private Class<Student> getEntityClass() {
        return Student.class;
    }

}
