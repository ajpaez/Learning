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
import javax.persistence.criteria.*;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void findAllCoursesTest() {
        // Select c From Cource c

        //1 - Get a Criteria Builder to create a query base
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2 - Select roots for tables that will use in the query
        Root<Course> courseRoot = cq.from(Course.class);

        //3 - common part, build the typed query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result-> {}", resultList);
    }

    @Test
    void findAllCoursesWithNameTest() {
        // "Select c From Course c where name like '%boot%'"

        //1 - Get a Criteria Builder to create a query base
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2 - Select roots for tables that will use in the query
        Root<Course> courseRoot = cq.from(Course.class);

        //3 - define the predicates
        //name like '%boot%'
        Predicate likeBoot = cb.like(courseRoot.get("name"), "%boot%");

        //4 - add predicates to criteria query
        cq.where(likeBoot);

        //5 - common part, build the typed query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result-> {}", resultList);
    }

    @Test
    void findAllCoursesWithStudentsTest() {
        // "Select c From Course c where c.students is empty"

        //1 - Get a Criteria Builder to create a query base
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2 - Select roots for tables that will use in the query
        Root<Course> courseRoot = cq.from(Course.class);

        //3 - define the predicates
        //c.students is empty
        Predicate studentsIsNotEmpty = cb.isNotEmpty(courseRoot.get("students"));

        //4 - add predicates to criteria query
        cq.where(studentsIsNotEmpty);

        //5 - common part, build the typed query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result-> {}", resultList);
    }

    @Test
    void findAllCoursesAndItsStudentsTest() {
        // "Select c, s From Course c JOIN c.students s"

        //1 - Get a Criteria Builder to create a query base
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2 - Select roots for tables that will use in the query
        Root<Course> courseRoot = cq.from(Course.class);

        //3 - define the join
        Join<Object, Object> join = courseRoot.join("students");

        //4 - common part, build the typed query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result size-> {}", resultList.size());
        assertTrue("All courses with students", resultList.size() == 4);
    }
}
