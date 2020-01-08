package com.apr.learning.jdbctojpa;

import com.apr.learning.jdbctojpa.jdbc.entity.Person;
import com.apr.learning.jdbctojpa.jdbc.PersonDao;
import com.apr.learning.jdbctojpa.jpa.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JdbcToJpaApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonDao personDao;

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(JdbcToJpaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // uncomment the method that you want check

        /******JDBC******/
        //jdbc();

        /******JPA******/
        //jpa();


    }

    private void jdbc() {
        List<Person> persons = personDao.findAll();
        for (Person p : persons) {
            logger.info("Person -> " + p.toString());
        }

        logger.info("Person id 10001-> " + personDao.findById(10001).toString());

        logger.info("Deleting person with ID 10002: " + personDao.deleteById(10002));

        logger.info("Adding new person with ID 10004: " + personDao.insert(new Person(10004, "NAME4", "Location4", new Date())));

        logger.info("Update person with ID 10004: " + personDao.update(new Person(10004, "NAME4$", "Location44", new Date())));
        logger.info("Person id 10004-> " + personDao.findById(10004).toString());

        logger.info("Persons with our own mapper");
        persons = personDao.findAll();
        for (Person p : persons) {
            logger.info("Person -> " + p.toString());
        }
    }

    private void jpa() {
        logger.info("Person id 10001-> " + personRepository.findById(10001).toString());

        com.apr.learning.jdbctojpa.jpa.entity.Person person = personRepository.insert(new com.apr.learning.jdbctojpa.jpa.entity.Person("NAME4", "Location4", new Date()));

        logger.info("Adding new person: " + person.toString());

        logger.info("Update person with ID: " + person.getId());
        person.setName("new name");
        logger.info(personRepository.update(person).toString());

        logger.info("Deleting person with ID 10002: " + person.getId());
        personRepository.deleteById(person.getId());


        logger.info("Find all persons");
        List<com.apr.learning.jdbctojpa.jpa.entity.Person> persons = personRepository.findAll();
        for (com.apr.learning.jdbctojpa.jpa.entity.Person p : persons) {
            logger.info("Person -> " + p.toString());
        }


    }
}
