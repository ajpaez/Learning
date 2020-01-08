package com.apr.learning.hibernate.inheritance.repository;

import com.apr.learning.hibernate.inheritance.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    private EntityManager entityManager;

    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query =
                entityManager.createQuery("Select  c  From Employee c", Employee.class);
        List<Employee> resultList = query.getResultList();
        return resultList;
    }
}
