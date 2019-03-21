package com.ttn.springboot.repository;

import com.ttn.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addStudent(Student student){
        String sql = "Insert into student (name, age, email) values (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getEmail());
    }

    public Student getStudent(int id){
        String sql = "select * from student where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (ResultSet rs, int rowNum) -> {
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));
                return student;
        });
    }

    public int updateStudent(int id, Student student){
        String sql = "Update student Set name = ?, age = ?, email = ? where id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getEmail(), id);
    }

    public void deleteStudent(int id){
        String sql = "Delete from student where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Integer getTotalRecords(){
        String sql = "select count(*) from student";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
