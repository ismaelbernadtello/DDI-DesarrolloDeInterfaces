package com.in28minutes.springboot.jdbc.h2.example.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class studentJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?",
                new BeanPropertyRowMapper<>(student.class), id);
    }

    static class StudentRowMapper implements RowMapper<student> {
        @Override
        public student mapRow(ResultSet rs, int rowNum) throws SQLException {
            student student = new student();
            student.setid(rs.getLong("id"));
            student.setname(rs.getString("name"));
            student.setpassportnumber(rs.getString("passport_number"));
            return student;
        }

    }

    public List<student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    public void deleteById(long id) {
        jdbcTemplate.update("delete from student where id=?", id);
    }

    public int insert(student student) {
        return jdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
                student.getid(), student.getname(), student.getpassportnumber());
    }

    public int update(student student) {
        return jdbcTemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
                student.getname(), student.getpassportnumber(), student.getid());
    }

}