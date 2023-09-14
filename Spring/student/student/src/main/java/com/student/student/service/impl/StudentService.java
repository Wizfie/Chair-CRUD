package com.student.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student.model.Student;
import com.student.student.repository.IStudentRepository;
import com.student.student.service.IStudentService;


@Service
public class StudentService implements IStudentService{

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.insertStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student updateStudent(int id, Student student) {
        return studentRepository.updateStudent(id, student);
    }

    @Override
    public Student deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public Student updateByiStudent(long id) {
        return studentRepository.updateByiStudent(id);
    }

   

    
}
