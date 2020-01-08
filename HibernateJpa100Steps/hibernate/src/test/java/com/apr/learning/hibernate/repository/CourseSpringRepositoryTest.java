package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.HibernateApplication;
import com.apr.learning.hibernate.entity.Course;
import com.apr.learning.hibernate.entity.Review;
import com.apr.learning.hibernate.entity.ReviewRating;
import com.apr.learning.hibernate.entity.Student;
import net.bytebuddy.TypeCache;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CourseSpringRepositoryTest {

    @Autowired
    CourseSpringRepository courseRepository;

    @Autowired
    ReviewSpringRepository reviewSpringRepository;

    @Autowired
    StudentSpringRepository studentSpringRepository;

    @Test
    void findByIdTest() {
        Optional<Course> course = courseRepository.findById(10001L);
        assertTrue(course.isPresent());
        assertEquals("JPA course 1", course.get().getName());

        course = courseRepository.findById(11111L);
        assertFalse(course.isPresent());
    }

    @Test
    @DirtiesContext
    @Transactional
    void deleteByIdTest() {
        Optional<Course> course = courseRepository.findById(10001L);
        assertTrue(course.isPresent());
        assertEquals("JPA course 1", course.get().getName());

        List<Review> reviews = reviewSpringRepository.findAllByCourse(course.get());
        assertTrue(reviews.size() == 2);

        List<Student> students = studentSpringRepository.findAllByCourses(course.get());
        assertTrue(students.size() == 2);

        //remove the association with students
        for (Student s : students) {
            s.removeCourse(course.get());
        }

        courseRepository.delete(course.get());
        assertFalse(courseRepository.findById(10001L).isPresent());

        //the relations has been deleted
        assertTrue(reviewSpringRepository.findAllByCourse(course.get()).size() == 0);
        assertTrue(studentSpringRepository.findAllByCourses(course.get()).size() == 0);

        //but the students hasn't been deleted
        assertTrue(studentSpringRepository.findById(students.get(0).getId()).isPresent());
        assertTrue(studentSpringRepository.findById(students.get(1).getId()).isPresent());
    }

    @Test
    @DirtiesContext
    void updateTest() {
        Optional<Course> course = courseRepository.findById(10001L);
        assertTrue(course.isPresent());
        assertEquals("JPA course 1", course.get().getName());

        course.get().setName("JPA course 2222");
        courseRepository.save(course.get());

        course = courseRepository.findById(10001L);
        assertTrue(course.isPresent());
        assertEquals("JPA course 2222", course.get().getName());
        assertNotNull(course.get().getUpdatedDate());
    }


    @Test
    @DirtiesContext
    void saveTest() {
        Course newCourse = new Course();
        newCourse.setName("New course");
        Course courseSaved = courseRepository.save(newCourse);

        Optional<Course> course = courseRepository.findById(courseSaved.getId());
        assertTrue(course.isPresent());
        assertEquals(courseSaved.getName(), course.get().getName());
        assertNotNull(course.get().getCreatedDate());
    }

    @Test
    @DirtiesContext
    @Transactional
    void insertReviewTest() {
        Optional<Course> course = courseRepository.findById(10002L);
        assertTrue(course.isPresent());
        assertEquals("Spring boot course", course.get().getName());
        assertTrue(reviewSpringRepository.findAllByCourse(course.get()).size() == 0);

        Review review = new Review(ReviewRating.FIVE, "The best");
        review.setCourse(course.get());
        course.get().addReview(review);
        courseRepository.save(course.get());

        List<Review> reviews = reviewSpringRepository.findAllByCourse(course.get());

        assertTrue(reviews.size() == 1);
        assertTrue(reviews.get(0).getRating().equals(review.getRating()));
        assertTrue(reviews.get(0).getDescription().equals(review.getDescription()));
    }


    @Test
    @DirtiesContext
    @Transactional
    void removeReviewTest() {
        Optional<Course> course = courseRepository.findById(10001L);
        assertTrue(course.isPresent());
        assertEquals("JPA course 1", course.get().getName());
        assertTrue(reviewSpringRepository.findAllByCourse(course.get()).size() == 2);

        Review reviewToDelete = course.get().getReviews().get(0);
        course.get().removeReview(reviewToDelete);
        courseRepository.save(course.get());

        assertTrue(reviewSpringRepository.findAllByCourse(course.get()).size() == 1);
    }

    @Test
    @Transactional
    void findStudentsByIdTest() {
        Optional<Course> course = courseRepository.findById(10001L);
        assertTrue(course.isPresent());
        assertEquals("JPA course 1", course.get().getName());

        Set<Student> students = course.get().getStudents();

        assertTrue(students.size() == 2);
        List<Long> ids = students.stream().map(s -> s.getId()).collect(Collectors.toList());

        assertTrue(ids.contains(20001L));
        assertTrue(ids.contains(20002L));
    }

    @Test
    @Transactional
    @DirtiesContext
    void addAndRemoveStudentsByIdTest() {
        Optional<Course> course = courseRepository.findById(10001L);
        assertTrue(course.isPresent());
        assertEquals("JPA course 1", course.get().getName());

        List<Student> students = studentSpringRepository.findAllByCourses(course.get());

        assertTrue(students.size() == 2);

        Student newStudent = new Student("Tony");
        newStudent.addCourse(course.get());
        newStudent = studentSpringRepository.save(newStudent);

        course.get().addStudent(newStudent);
        courseRepository.save(course.get());

        students = studentSpringRepository.findAllByCourses(course.get());
        assertTrue(students.size() == 3);

        course.get().removeStudent(newStudent);
        studentSpringRepository.delete(newStudent);
        students = studentSpringRepository.findAllByCourses(course.get());
        assertTrue(students.size() == 2);
    }

    @Test
    void findAllSortByName() {
        List<Course> courses = courseRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        assertEquals("Angular 8 course", courses.get(0).getName());

        courses = courseRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        assertEquals("Spring boot course", courses.get(0).getName());
    }

    @Test
    void findAllPaginated() {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        Page<Course> courses = courseRepository.findAll(firstPageWithTwoElements);
        assertEquals(courses.getNumberOfElements(), 2);
        assertTrue(courses.get().anyMatch(course -> course.getId() == 10001L));
        assertTrue(courses.get().anyMatch(course -> course.getId() == 10002L));

        Pageable secondPage = courses.nextPageable();
        courses = courseRepository.findAll(secondPage);
        assertEquals(courses.getNumberOfElements(), 2);
        assertTrue(courses.get().anyMatch(course -> course.getId() == 10003L));
        assertTrue(courses.get().anyMatch(course -> course.getId() == 10004L));

    }

    @Test
    void findAllbyName() {
        List<Course> courses = courseRepository.findAllByName("Angular course");
        assertEquals(courses.size(), 1);


        courses = courseRepository.findAllByNameContains("Angular");
        assertEquals(courses.size(), 2);

    }



}
