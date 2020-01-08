package com.apr.learning.jdbctojpa.jdbc.rowmapper;

import com.apr.learning.jdbctojpa.jdbc.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonRowMapper implements RowMapper<Person> {

    /**
     * Parameters:
     * @param rs - the ResultSet to map (pre-initialized for the current row)
     * @param i - the number of the current row
     */
    @Override
    public Person mapRow(ResultSet rs, int i) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setLocation(rs.getString("location"));
        person.setBirthDate(rs.getTime("birth_date"));
        return person;
    }
}

