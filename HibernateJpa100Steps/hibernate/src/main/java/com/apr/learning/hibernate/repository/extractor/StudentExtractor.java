package com.apr.learning.hibernate.repository.extractor;

import com.apr.learning.hibernate.entity.Passport;
import com.apr.learning.hibernate.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentExtractor implements ResultSetExtractor<Student> {

    @Override
    public Student extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Student student = null;
        while (resultSet.next()) {
                if (student == null){
                    student = new Student(
                            resultSet.getLong("sId"),
                            resultSet.getString("sName")
                    );
                    Passport passport = new Passport(resultSet.getString("pNum"));
                    student.setPassport( passport);
                }
        }
        return student;
    }
}
