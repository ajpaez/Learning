package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByName(String name);


    List<Course> findAllByNameContains(String name);
}
