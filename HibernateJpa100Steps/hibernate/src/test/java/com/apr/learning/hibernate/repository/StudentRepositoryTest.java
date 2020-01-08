package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.HibernateApplication;
import com.apr.learning.hibernate.entity.*;
import com.apr.learning.hibernate.entity.Student;
import com.apr.learning.hibernate.entity.Student;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PassportRepository passportRepository;
    @Autowired
    CourseRepository courseRepository;

    @Test
    @Transactional //we need to add for retrieve the passport info, otherwise LazyInitializationException: could not initialize proxy - no Session is throw
    void findByIdTest() {
        Student student = studentRepository.findById(20001L);
        assertEquals("Ranga", student.getName());
        logger.info("Passport's student {}", student.getPassport());
    }

    @Test
    //It indicates the associated test or class modifies the ApplicationContext.
    //It tells the testing framework to close and recreate the context for later tests.
    @DirtiesContext
    void deleteByIdTest() {
        Student student = studentRepository.findById(20001L);
        assertEquals("Ranga", student.getName());

        studentRepository.deleteById(20001L);

        student = studentRepository.findById(20001L);
        assertNull(student);
        Passport passport = passportRepository.findById(20001L);
        assertNull(passport);
    }

    @Test
    @DirtiesContext
    void updateTest() {
        Student student = studentRepository.findById(20001L);
        assertEquals("Ranga", student.getName());

        student.setName("Ranga Ranga");
        studentRepository.save(student);

        student = studentRepository.findById(20001L);
        assertEquals("Ranga Ranga", student.getName());
    }

    @Test
    @DirtiesContext
    void saveTest() {
        Student student = new Student("Tony");
        Passport passport = new Passport("ABC789");
        student.setPassport(passport);
        passport.setStudent(student);
        Student studentSaved = studentRepository.save(student);

        student = studentRepository.findById(studentSaved.getId());
        assertEquals(studentSaved.getName(), student.getName());
        assertEquals(studentSaved.getName(), "Tony");

        Passport passport2 = passportRepository.findById(student.getId());
        assertNotNull(passport2);
        assertEquals("ABC789", passport2.getNumber());
    }

    @Test
    void findAllTypedTest() {
        List<Student> students = studentRepository.findAllTyped();
        assertTrue(students.size() == 3);
        students.forEach(student -> assertTrue(student instanceof Student));
    }

    @Test
    @Transactional
    void findAllCoursesByIdTest() {
        Student student = studentRepository.findById(20001L);
        assertEquals("Ranga", student.getName());

        Set<Course> courses = studentRepository.findAllCoursesByStudentId(student.getId());

        assertTrue(courses.size() == 2);
        assertNotNull(new ArrayList<>(courses).stream().filter(course -> course.getId() == 10001L));
        assertNotNull(new ArrayList<>(courses).stream().filter(course -> course.getId() == 10002L));
    }

    @Test
    @DirtiesContext
    @Transactional
    void addCourseTest() {
        Student student = studentRepository.findById(20001L);
        assertEquals("Ranga", student.getName());

        Set<Course> courses = studentRepository.findAllCoursesByStudentId(student.getId());
        assertTrue(courses.size() == 2);


        Course angularCourse = courseRepository.findById(10003L);

        student = studentRepository.addCourse(student.getId(), angularCourse);

        courses = studentRepository.findAllCoursesByStudentId(student.getId());
        assertTrue(courses.size() == 3);

        assertNotNull(new ArrayList<>(courses).stream().filter(course -> course.getId() == 20001L));
        assertNotNull(new ArrayList<>(courses).stream().filter(course -> course.getId() == 20002L));
        assertNotNull(new ArrayList<>(courses).stream().filter(course -> course.getId() == 20001L));
    }

}
