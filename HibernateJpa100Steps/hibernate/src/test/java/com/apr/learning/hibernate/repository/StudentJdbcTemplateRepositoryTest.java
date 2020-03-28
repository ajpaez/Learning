package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.HibernateApplication;
import com.apr.learning.hibernate.entity.Student;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class StudentJdbcTemplateRepositoryTest {

    @Autowired
    StudentJdbcTemplateRepository studentRepository;

    @Test
    void findByIdTest() {
        Optional<Student> student = studentRepository.findById(20001L);
        assertEquals("Ranga", student.get().getName());
    }

    @Test
    //It indicates the associated test or class modifies the ApplicationContext.
    //It tells the testing framework to close and recreate the context for later tests.
    @DirtiesContext
    void deleteByIdTest() {
        Student student = new Student(1L,"Tony");
        int studentSaved = studentRepository.save(student);
        assertEquals(studentSaved, 1);


        Optional<Student> studentStored = studentRepository.findByName(student.getName());
        assertEquals("Tony", studentStored.get().getName());

        studentRepository.deleteById(studentStored.get().getId());
        assertThrows(EmptyResultDataAccessException.class, () -> studentRepository.findById(studentStored.get().getId()));
    }

    @Test
    void findByIdWithNamedParameterTest() {
        Optional<Student> student = studentRepository.findByIdWithNamedParameter(20001L);
        assertEquals("Ranga", student.get().getName());
    }

    @Test
    @DirtiesContext
    void saveTest() {
        Student student = new Student(1L, "Tony");
        int studentSaved = studentRepository.save(student);
        assertEquals(studentSaved, 1);
    }

    @Test
    void findAllTest() {
        List<Student> students = studentRepository.findAll();
        assertTrue(students.size() == 3);
        students.forEach(student -> assertTrue(student instanceof Student));
    }

    @Test
    void findAllMappedTest() {
        Set<Student> students = studentRepository.findAllMapped();
        assertTrue(students.size() == 3);
        students.forEach(student -> assertTrue(student instanceof Student));
    }

    @Test
    void countTest() {
        int countStudents = studentRepository.count();
        assertTrue(countStudents == 3);
    }

    @Test
    void findAllWithCallableTest() {
        studentRepository.findAllWithCallable();
    }

    @Test
    void findByIdFullEntity() {
        Optional<Student> studentFound = studentRepository.findByIdWithPassport(20001L);
        assertEquals("Ranga", studentFound.get().getName());
        assertNotNull(studentFound.get().getPassport());
        assertEquals("E123456", studentFound.get().getPassport().getNumber());
    }


}
