package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.HibernateApplication;
import com.apr.learning.hibernate.entity.Course;
import com.apr.learning.hibernate.entity.Review;
import com.apr.learning.hibernate.entity.ReviewRating;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    private Logger logger = LoggerFactory.getLogger(CourseRepositoryTest.class);

    @Test
    void findByIdTest() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA course 1", course.getName());
    }

    @Test
    //It indicates the associated test or class modifies the ApplicationContext.
    //It tells the testing framework to close and recreate the context for later tests.
    @DirtiesContext
    @Transactional
    void deleteByIdTest() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA course 1", course.getName());

        List<Review> reviews = courseRepository.findAllReviewsByCourseId(course.getId());
        assertTrue(reviews.size() == 2);

        Set<Student> students = courseRepository.findAllStudentsByCourseId(course.getId());
        assertTrue(students.size() == 2);

        //remove the association with students
        for (Student s : students) {
            s.removeCourse(course);
        }

        courseRepository.deleteById(10001L);
        assertNull(courseRepository.findById(10001L));

        reviews = courseRepository.findAllReviewsByCourseId(course.getId());
        assertTrue(reviews.size() == 0);
    }

    @Test
    @DirtiesContext
    void updateTest() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA course 1", course.getName());

        course.setName("JPA course 2222");
        courseRepository.save(course);

        course = courseRepository.findById(10001L);
        assertEquals("JPA course 2222", course.getName());
        assertNotNull(course.getUpdatedDate());
    }


    @Test
    @DirtiesContext
    void saveTest() {
        Course course = new Course();
        course.setName("New course");
        Course courseSaved = courseRepository.save(course);

        course = courseRepository.findById(courseSaved.getId());
        assertEquals(courseSaved.getName(), course.getName());
        assertNotNull(course.getCreatedDate());
    }

    @Test
    @DirtiesContext
    @Transactional
    void insertReviewTest() {
        Course course = courseRepository.findById(10002L);
        assertEquals("Spring boot course", course.getName());
        assertTrue(courseRepository.findAllReviewsByCourseId(course.getId()).size() == 0);

        Review review = new Review(ReviewRating.FIVE, "The best");

        courseRepository.addReviewInCourse(course, review);

        List<Review> reviews = courseRepository.findAllReviewsByCourseId(course.getId());

        assertTrue(reviews.size() == 1);
        assertTrue(reviews.get(0).getRating().equals(review.getRating()));
        assertTrue(reviews.get(0).getDescription().equals(review.getDescription()));
    }


    @Test
    @DirtiesContext
    @Transactional
    void removeReviewTest() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA course 1", course.getName());
        assertTrue(courseRepository.findAllReviewsByCourseId(course.getId()).size() == 2);

        Review reviewToDelete = course.getReviews().get(0);

        courseRepository.removeReviewInCourse(course, reviewToDelete);

        List<Review> reviews = courseRepository.findAllReviewsByCourseId(course.getId());

        assertTrue(reviews.size() == 1);
    }

    @Test
    @Transactional
    void findStudentsByIdTest() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA course 1", course.getName());

        Set<Student> students = courseRepository.findAllStudentsByCourseId(course.getId());

        assertTrue(students.size() == 2);
        assertNotNull(new ArrayList<>(students).stream().filter(student -> student.getId() == 20001L));
        assertNotNull(new ArrayList<>(students).stream().filter(student -> student.getId() == 20002L));
    }

    @Test
    @Transactional
    @DirtiesContext
    void addAndRemoveStudentsByIdTest() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA course 1", course.getName());

        Set<Student> students = courseRepository.findAllStudentsByCourseId(course.getId());

        assertTrue(students.size() == 2);

        Student newStudent = new Student("Tony");

        courseRepository.addStudentInCourse(course, newStudent);
        students = courseRepository.findAllStudentsByCourseId(course.getId());
        assertTrue(students.size() == 3);

        courseRepository.removeStudentInCourse(course, newStudent);
        students = courseRepository.findAllStudentsByCourseId(course.getId());
        assertTrue(students.size() == 2);

    }

    @Test
    @DirtiesContext
    void checkTransactionalityTest() {
        courseRepository.onlyForCheckTransactionality();
    }

    @Test
    @DirtiesContext
    void onlyForCheckDetachTest() {
        courseRepository.onlyForCheckDetach();
    }

    @Test
    @DirtiesContext
    void onlyForCheckClearTest() {
        courseRepository.onlyForCheckClear();
    }

    @Test
    @DirtiesContext
    void onlyForCheckRefreshTest() {
        courseRepository.onlyForCheckRefresh();
    }

    @Test
    void findAllWithoutTypeTest() {
        List courses = courseRepository.findAllWithoutType();
        assertTrue(courses.size() == 4);
    }

    @Test
    void findAllTypedTest() {
        List<Course> courses = courseRepository.findAllTyped();
        assertTrue(courses.size() == 4);
    }

    @Test
    void findAllTypedWithWhereTest() {
        List<Course> courses =courseRepository.findAllTypedWithWhere();
        assertTrue(courses.size() == 1);
    }

    @Test
    void findAllWithCreatedQueryTypedTest() {
        List<Course> courses =courseRepository.findAllWithCreatedQueryTyped();
        assertTrue(courses.size() == 4);
    }


    @Test
    @Transactional //we need a transaction to be able to use the cache
    void findByIdCheckFirstLevelCacheTest() {
        Course course = courseRepository.findById(10001L);
        logger.info("First select -> {}", course.toString());
        //after that we must see a select from course

        Course course1 = courseRepository.findById(10001L);
        logger.info("Second select -> {}", course1.toString());
        //after that, we mustn't see a select from course
    }

    @Test
    void findByIdCheckSecondLevelCacheTest() {
        Course course = courseRepository.findById(10001L); //run over own transaction
        logger.info("First select -> {}", course.toString());
        //after that we must see a select from course

        Course course1 = courseRepository.findById(10001L); //run over own transaction
        logger.info("Second select -> {}", course1.toString());
        //after that, we mustn't see a select from course without the @Transactional
    }


}
