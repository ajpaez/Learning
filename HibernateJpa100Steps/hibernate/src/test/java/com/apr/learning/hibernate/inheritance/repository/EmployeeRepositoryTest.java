package com.apr.learning.hibernate.inheritance.repository;

import com.apr.learning.hibernate.HibernateApplication;
import com.apr.learning.hibernate.entity.Course;
import com.apr.learning.hibernate.entity.Review;
import com.apr.learning.hibernate.entity.Student;
import com.apr.learning.hibernate.inheritance.entity.Employee;
import com.apr.learning.hibernate.inheritance.entity.FullTimeEmployee;
import com.apr.learning.hibernate.inheritance.entity.PartTimeEmployee;
import com.apr.learning.hibernate.repository.CourseRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DirtiesContext
    void insertEmployeeTest() {
        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("10")));
        List<Employee> employees = employeeRepository.findAll();
        assertTrue(employees.size() == 2);
    }

}
