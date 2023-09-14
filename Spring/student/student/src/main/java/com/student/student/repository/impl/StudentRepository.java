package com.student.student.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.student.student.model.Student;
import com.student.student.repository.IStudentRepository;
@Repository
public class StudentRepository implements IStudentRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Student insertStudent(Student student) {

        String query = "INSERT INTO tb_student(deskripsi_diri, email, hard_skill, interest, jenis_kelamin, nama,soft_skill,umur) "
				+ "VALUES(?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(query, new Object[] {student.getDeskripsi_diri(), student.getEmail(), student.getHard_skill(),
				student.getInterest(), student.getJenis_kelamin(), student.getNama(), student.getSoft_skill(),student.getUmur()});
		return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "SELECT * FROM tb_student";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
	}


    @Override
    public Student updateStudent(int id, Student student) {
       String query = "UPDATE tb_student SET deskripsi_diri = ?, email = ?, hard_skill = ?, interest = ?, jenis_kelamin = ?, nama = ?, soft_skill = ? ,umur = ? WHERE id = ?";
		
                jdbcTemplate.update(query, new Object[] {student.getDeskripsi_diri(), student.getEmail(), student.getHard_skill(),
                    student.getInterest(), student.getJenis_kelamin(), student.getNama(), student.getSoft_skill(),student.getUmur(),id});
            return student;
    }

    @Override
    public Student deleteStudent(int id) {
        String query = "SELECT * FROM tb_student WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class), id);
		
		query = "DELETE FROM tb_student WHERE id = ?";
		jdbcTemplate.update(query, id);
		
		return result;
    }

    @Override
    public Student updateByiStudent(long id) {
        String query = "SELECT * FROM tb_student WHERE id = ?";
          return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class), id);
          
    }

   
    
}
