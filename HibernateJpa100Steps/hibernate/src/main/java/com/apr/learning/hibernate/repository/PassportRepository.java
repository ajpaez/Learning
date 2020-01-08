package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PassportRepository {

    @Autowired
    private EntityManager entityManager;


    public Passport findById(Long id) {
        return entityManager.find(Passport.class, id);
    }

    //https://stackoverflow.com/questions/1069992/jpa-entitymanager-why-use-persist-over-merge
    public Passport save(Passport passport) {
        if (passport.getId() == null) {
            entityManager.persist(passport);
        } else {
            passport = entityManager.merge(passport);
        }
        return passport;
    }

    public void deleteById(Long id) {
        Passport c = findById(id);
        entityManager.remove(c);
    }

    //***************
    //SELECT QUERIES
    //***************


    public List<Passport> findAllTyped() {
        TypedQuery<Passport> query =
                entityManager.createQuery("Select  c  From Passport c", Passport.class);
        List<Passport> resultList = query.getResultList();
        return resultList;
    }
}
