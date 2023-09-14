package com.student.student.repository;

import java.util.List;

import com.student.student.model.Student;

public interface IStudentRepository {
    public Student insertStudent(Student student);
	public List<Student> getAllStudents();
	public Student updateStudent(int id, Student student);
	public Student deleteStudent(int id);
	public Student updateByiStudent(long id);
}
