package com.geekster.EventManagementSystem.service;

import com.geekster.EventManagementSystem.exception.StudentNotFoundException;
import com.geekster.EventManagementSystem.model.Department;
import com.geekster.EventManagementSystem.model.Student;
import com.geekster.EventManagementSystem.repo.Istudentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Studentservice {
    @Autowired
    Istudentrepo iStudentrepo;







    public String addStudents(List<Student> newstudents) {
    iStudentrepo.saveAll(newstudents);
    return newstudents.size()+ "student added";
    }

    public List<Student> getAllStudents() {
        return  iStudentrepo.findAll();
    }

    public Student getStudentById(Long id) {
        return iStudentrepo.findById(id).get();
    }

    public String deleteStudentById(Long id) {
         iStudentrepo.deleteById(id);
         return "student removed";
    }

    public Student updateStudentDepartment(Long studentId, Department newDepartment) {
        Student existingStudent = iStudentrepo.findById(studentId).orElse(null);

        if (existingStudent != null) {
            existingStudent.setDepartment(newDepartment);
            return  iStudentrepo.save(existingStudent);
        } else {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }
    }
}
