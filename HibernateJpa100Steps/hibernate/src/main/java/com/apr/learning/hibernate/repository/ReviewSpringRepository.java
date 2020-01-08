package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Course;
import com.apr.learning.hibernate.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewSpringRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByCourse(Course course);
}
