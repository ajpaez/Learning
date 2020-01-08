package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.HibernateApplication;
import com.apr.learning.hibernate.entity.Passport;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class PassportRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PassportRepository passportRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findByIdTest() {
        Passport passport = passportRepository.findById(20001L);
        assertEquals("E123456", passport.getNumber());
    }

    @Test
    //It indicates the associated test or class modifies the ApplicationContext.
    //It tells the testing framework to close and recreate the context for later tests.
    @DirtiesContext
    void deleteByIdTest() {
        Passport passport = passportRepository.findById(20001L);
        assertEquals("E123456", passport.getNumber());

        passportRepository.deleteById(20001L);

        passport = passportRepository.findById(20001L);
        assertNull(passport);
    }

    @Test
    @DirtiesContext
    void updateTest() {
        Passport passport = passportRepository.findById(20001L);
        assertEquals("E123456", passport.getNumber());

        passport.setNumber("E123456789");
        passportRepository.save(passport);

        passport = passportRepository.findById(20001L);
        assertEquals("E123456789", passport.getNumber());
    }


    @Test
    @DirtiesContext
    void saveTest() {
        Passport passport = new Passport("ABC789");
        Student student = new Student("Tony");
        student.setPassport(passport);
        passport.setStudent(student);
        studentRepository.save(student);

        Student student2 = studentRepository.findById(student.getId());
        assertNotNull(student2);
        assertEquals("Tony", student2.getName());

        Passport passport2 = passportRepository.findById(student.getId());
        assertNotNull(passport2);
        assertEquals("ABC789", passport2.getNumber());

    }


    @Test
    void findAllTypedTest() {
        List<Passport> passports = passportRepository.findAllTyped();
        assertTrue(passports.size() == 3);
        passports.forEach(passport -> assertTrue(passport instanceof Passport));
    }

    @Test
    @Transactional
    void findStudentByPassportTest() {
        Passport passport = passportRepository.findById(20001L);
        assertEquals("E123456", passport.getNumber());
        logger.info("Passport's student {}", passport.getStudent());
    }

}
