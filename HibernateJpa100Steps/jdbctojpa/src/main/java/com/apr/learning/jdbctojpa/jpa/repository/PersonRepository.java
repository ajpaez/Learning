package com.apr.learning.jdbctojpa.jpa.repository;


import com.apr.learning.jdbctojpa.jpa.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;


    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }


    public Person update(Person person){
        return entityManager.merge(person);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person p = findById(id);
        entityManager.remove(p);
    }

    public List<Person> findAll() {
        TypedQuery<Person> namdQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namdQuery.getResultList();
    }
}
