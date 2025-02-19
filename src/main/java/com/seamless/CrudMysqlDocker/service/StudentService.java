package com.seamless.CrudMysqlDocker.service;

import com.seamless.CrudMysqlDocker.entity.Student;
import com.seamless.CrudMysqlDocker.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void insertStudent(Student student) {
        studentRepo.save(student);
    }

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepo.findById(id);
        return student.orElse(null);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }
    public String updateStudent(int id, Student updatedStudent) {
        Optional<Student> studentData = studentRepo.findById(id);
        if (studentData.isPresent()) {
            Student student = studentData.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setPhone(updatedStudent.getPhone());
            studentRepo.save(student);
            return "Student updated successfully";
        } else {
            return "Student not found";
        }
    }
}
