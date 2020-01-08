package com.apr.learning.hibernate;

import com.apr.learning.hibernate.entity.Course;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class JpqlTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    void findAllWithJpqlTest() {
        Query query = entityManager.createQuery("Select c From Course c");
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    void findAllTypedWithJpqlTest() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    void findByIdWithJpqlTest() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where name like '%boot%'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c where name like '%boot%' -> {}", resultList);
    }

    @Test
    void findAllCoursesWithoutStudentsTest() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where c.students is empty order by c.id", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Result-> {}", resultList);

        assertTrue(resultList.size() == 2);
        assertTrue(resultList.get(0).getId() == 10003L);
        assertTrue(resultList.get(1).getId() == 10004L);
    }

    @Test
    void findCoursesWithAtLeatsStudentsTest() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where size(c.students) >= 2 ", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Result-> {}", resultList);

        assertTrue(resultList.size() == 2);
        assertTrue(
                resultList
                        .stream().filter(course -> course.getId()== 10001L)
                        .count() == 1
        );
        assertTrue(resultList.size() == 2);
        assertTrue(
                resultList
                        .stream().filter(course -> course.getId()== 10002L)
                        .count() == 1
        );
    }

    @Test
    void findAllCoursesOrderByStudentsTest() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c order by size(c.students) asc, c.id asc", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Result-> {}", resultList);

        assertTrue(resultList.get(0).getId() == 10003L);
        assertTrue(resultList.get(1).getId() == 10004L);
        assertTrue(resultList.get(2).getId() == 10001L);
        assertTrue(resultList.get(3).getId() == 10002L);
    }

    @Test
    void findAllCoursesWithGoodReviewTest() {
        TypedQuery<Course> query = entityManager.createQuery("Select r.course From Review r where r.rating ='FOUR' or r.rating ='FIVE' group by r.course.id", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Result-> {}", resultList);

        assertTrue(resultList.size() == 2);
        assertNotNull(new ArrayList<>(resultList).stream().filter(course -> course.getId() == 10001L));
        assertNotNull(new ArrayList<>(resultList).stream().filter(course -> course.getId() == 10003L));
    }

    @Test
    void findAllCoursesWithtStudentsByJoinGoodReviewTest() {
        Query query = entityManager.createQuery("Select c, s From Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result size-> {}", resultList.size());
        assertTrue("All courses with students", resultList.size() == 4);

        for(Object[] result : resultList){
            logger.info("{} and {}", result[0], result[1]);
        }

    }

    @Test
    void findAllCoursesWithtStudentsByLeftJoinGoodReviewTest() {
        Query query = entityManager.createQuery("Select c, s From Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result size-> {}", resultList.size());
        assertTrue("All courses with students and without", resultList.size() == 6);

        for(Object[] result : resultList){
            logger.info("{} and {}", result[0], result[1]);
        }

    }
}
