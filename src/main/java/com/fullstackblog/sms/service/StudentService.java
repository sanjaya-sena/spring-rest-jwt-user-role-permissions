package com.fullstackblog.sms.service;

import com.fullstackblog.sms.exceptions.ResourceNotFoundException;
import com.fullstackblog.sms.models.Student;
import com.fullstackblog.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student saveOrUpdateStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudentByNic(String nic){
        Student student = studentRepository.findByNic(nic).orElseThrow(
                ()-> new ResourceNotFoundException("Student","nic",nic));
        return student;
    }
}
