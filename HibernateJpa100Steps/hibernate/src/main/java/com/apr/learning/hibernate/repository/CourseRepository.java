package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Course;
import com.apr.learning.hibernate.entity.Review;
import com.apr.learning.hibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Spring Boot configures Hibernate as the default JPA provider, so it's no longer necessary to define the
 * entityManagerFactory bean unless we want to customize it.
 */

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager entityManager;

    //https://stackoverflow.com/questions/1069992/jpa-entitymanager-why-use-persist-over-merge
    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            course = entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course c = findById(id);
        entityManager.remove(c);
        entityManager.flush();//force to check result in logs for test
    }


    public void addReviewInCourse(Course course, Review review){
        course.addReview(review);
        entityManager.persist(course);
        entityManager.flush();//force to check result in logs for test
    }

    public void removeReviewInCourse(Course course, Review review){
        course.removeReview(review);
        entityManager.persist(course);
        entityManager.flush();//force to check result in logs for test
    }

    public void addStudentInCourse(Course course, Student student){
        course.addStudent(student);
        entityManager.persist(course);
        entityManager.flush();//force to check result in logs for test
    }

    public void removeStudentInCourse(Course course, Student student){
        course.removeStudent(student);
        entityManager.persist(course);
        entityManager.flush();//force to check result in logs for test
    }

    //***************
    //SELECT QUERIES
    //***************


    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }
    
    public List findAllWithoutType() {
        Query query = entityManager.createQuery("Select  c  From Course c");
        List resultList = query.getResultList();
        return resultList;
    }
    
    public List<Course> findAllTyped() {
        TypedQuery<Course> query =
                entityManager.createQuery("Select  c  From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        return resultList;
    }

    public List<Course> findAllWithCreatedQueryTyped() {
        Query query = entityManager.createNamedQuery("query_get_all");
        List<Course> resultList = query.getResultList();
        return resultList;
    }

    public List<Course> findAllTypedWithWhere() {
        TypedQuery<Course> query =
                entityManager.createQuery("Select  c  From Course c where name like '%JPA course%'", Course.class);
        List<Course> resultList = query.getResultList();
        return resultList;
    }

    public List<Review> findAllReviewsByCourseId(Long idCourse){
        Course course = entityManager.find(Course.class, idCourse);
        if(course == null) {
            return new ArrayList<>();
        }else {
            return course.getReviews();
        }
    }

    public Set<Student> findAllStudentsByCourseId(Long idCourse){
        Course course = entityManager.find(Course.class, idCourse);
        if(course == null) {
            return new HashSet<>();
        }else {
            return course.getStudents();
        }
    }

    public void onlyForCheckTransactionality() {
        Course course = new Course();
        course.setName("New course");
        entityManager.persist(course); //insert into course (name, id) values (?, ?)
        course.setName("Rename the course");//update course set  name=? where id=?
    }

    public void onlyForCheckDetach() {
        Course course = new Course();
        course.setName("New course");
        entityManager.persist(course); //insert into course (name, id) values (?, ?)
        course.setName("Rename the course");//update course set  name=? where id=?
        entityManager.flush();

        Course course2 = new Course();
        course2.setName("New course 2");
        entityManager.persist(course2); //insert into course (name, id) values (?, ?)
        entityManager.flush();

        entityManager.detach(course2);
        course2.setName("Rename the course 2");// not execute sql
        entityManager.flush();
    }

    public void onlyForCheckClear() {
        Course course = new Course();
        course.setName("New course");
        entityManager.persist(course); //insert into course (name, id) values (?, ?)


        Course course2 = new Course();
        course2.setName("New course 2");
        entityManager.persist(course2); //insert into course (name, id) values (?, ?)

        entityManager.flush();
        entityManager.clear();

        course.setName("Rename the course");//not execute sql
        course2.setName("Rename the course 2");// not execute sql
        entityManager.flush();
    }

    public void onlyForCheckRefresh() {
        Course course = new Course();
        course.setName("New course");
        entityManager.persist(course); //insert into course (name, id) values (?, ?)
        Course course2 = new Course();
        course2.setName("New course 2");
        entityManager.persist(course2); //insert into course (name, id) values (?, ?)
        entityManager.flush();

        course.setName("Rename the course");//not execute sql
        course2.setName("Rename the course 2");// not execute sql

        entityManager.refresh(course);//select course0_.id as id1_0_0_, course0_.name as name2_0_0_ from course course0_ where course0_.id=course1
        entityManager.flush();//update course set name=? where  id=course2
    }
}
