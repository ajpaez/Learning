package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Course;
import com.apr.learning.hibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    private EntityManager entityManager;


    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    //https://stackoverflow.com/questions/1069992/jpa-entitymanager-why-use-persist-over-merge
    public Student save(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            student = entityManager.merge(student);
        }
        return student;
    }

    public void deleteById(Long id) {
        Student c = findById(id);
        entityManager.remove(c);
    }

    public Student addCourse(Long studentId, Course course){
        Student student = entityManager.find(Student.class, studentId);
        if(student != null) {
            student.addCourse(course);
            entityManager.merge(student);
            entityManager.flush();//force to check result in logs for test
        }
        return student;
    }

    //***************
    //SELECT QUERIES
    //***************

    public Set<Course> findAllCoursesByStudentId(Long idStudent){
        Student student = entityManager.find(Student.class, idStudent);
        if(student == null) {
            return new HashSet<>();
        }else {
            return student.getCourses();
        }
    }


    public List<Student> findAllTyped() {
        TypedQuery<Student> query =
                entityManager.createQuery("Select  c  From Student c", Student.class);
        List<Student> resultList = query.getResultList();
        return resultList;
    }
}
