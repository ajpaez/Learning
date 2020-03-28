package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Student;
import com.apr.learning.hibernate.repository.extractor.StudentExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

@Repository
@Transactional
public class StudentJdbcTemplateRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Optional<Student> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from student where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Student(
                                rs.getLong("id"),
                                rs.getString("name")
                        ))
        );
    }

    public Optional<Student> findByIdWithPassport(Long id) {
        String sql ="select s.id as sId, s.name as sName, p.number as pNum from student  as s, passport as p where s.id = " + id + " and s.id = p.id";
        return Optional.of(jdbcTemplate.query(sql, new StudentExtractor()));
    }

    public Optional<Student> findByIdWithNamedParameter(Long studentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", studentId);
        return namedParameterJdbcTemplate.queryForObject(
                "select * from student where id = :id",
                params,
                (rs, rowNum) ->
                        Optional.of(new Student(
                                rs.getLong("id"),
                                rs.getString("name")
                        ))
        );
    }


    public Optional<Student> findByName(String name) {
        return jdbcTemplate.queryForObject(
                "select * from student where name = ?",
                new Object[]{name},
                (rs, rowNum) ->
                        Optional.of(new Student(
                                rs.getLong("id"),
                                rs.getString("name")
                        ))
        );
    }

    //https://stackoverflow.com/questions/1069992/jpa-entitymanager-why-use-persist-over-merge
    public int save(Student student) {
        return jdbcTemplate.update(
                "insert into student (id, name) values(?, ?)",
                student.getId(),
                student.getName());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from student where id = ?",
                id);
    }

    public List<Student> findAll() {
        return jdbcTemplate.query(
                "select * from student",
                (rs, rowNum) ->
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
        );
    }

    public Set<Student> findAllMapped() {
        String sql = "select * from student";
        return new HashSet<>(jdbcTemplate.query(sql, new StudentRowMapper()));
    }

    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from student", Integer.class);
    }

    public void findAllWithCallable() {
        String sql = "select * from student";
        jdbcTemplate.query(sql, new HTMLStudentRowCallbackHandler(System.out));
    }

    private class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws
                SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            Student student = new Student(id, name);
            return student;
        }
    }

    private class HTMLStudentRowCallbackHandler implements RowCallbackHandler {
        private PrintStream out;

        public HTMLStudentRowCallbackHandler(PrintStream out) {
            this.out = out;
        }

        @Override
        public void processRow(ResultSet rs)
                throws SQLException {
            out.print("<p>Student id: ".concat(rs.getLong("id") + "")
                    .concat("</p></br>\n")
                    .concat("<p>name: ").concat(rs.getString("name"))
                    .concat("</p></br>\n"));
        }
    }

}
