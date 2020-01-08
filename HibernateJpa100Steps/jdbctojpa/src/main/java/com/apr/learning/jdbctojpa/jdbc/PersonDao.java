package com.apr.learning.jdbctojpa.jdbc;

import com.apr.learning.jdbctojpa.jdbc.entity.Person;
import com.apr.learning.jdbctojpa.jdbc.rowmapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonDao {

    @Autowired
    //https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    private JdbcTemplate jbJdbcTemplate;

    public List<Person> findAll() {
        return jbJdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findAllWithCustomRowMapper() {
        return jbJdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    public Person findById(int id) {
        // queryForObject - for single row or value
        return jbJdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
        return jbJdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }

    public int insert(Person person) {
        return jbJdbcTemplate.update("INSERT into PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES(?,?,?,?);",
                new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
    }

    public int update(Person person) {
        return jbJdbcTemplate.update("UPDATE PERSON set name = ?, location = ?, birth_date = ? where id = ?",
                new Object[]{
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()),
                        person.getId()});
    }
}
