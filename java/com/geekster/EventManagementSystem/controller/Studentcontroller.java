package com.geekster.EventManagementSystem.controller;

import com.geekster.EventManagementSystem.model.Department;
import com.geekster.EventManagementSystem.model.Student;
import com.geekster.EventManagementSystem.service.Studentservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated

public class Studentcontroller {
    @Autowired
    Studentservice studentservice;
    //1.add students
    @PostMapping("students")
    public String addstudents(@RequestBody @Valid List<Student> newstudents)
    {
          return   studentservice.addStudents(newstudents);

    }
    //2.get allstudents
    @GetMapping("students")
    public List<Student> getallstudents()
    {
        return studentservice.getAllStudents();
    }
    //3.get student by id
    @GetMapping("students/id/{id}")

        public Student getstudentsbyid( @PathVariable @Valid Long  id)
        {
            return studentservice.getStudentById(id);

        }
        //4.detete student
    @DeleteMapping("student/id/{id}")
    public String deletestudent(@PathVariable @Valid Long id){
     return  studentservice.deleteStudentById(id);
    }
    //5. update student department
    @PutMapping("/{studentId}/updateDepartment")
    public Student updateStudentDepartment(
            @PathVariable Long studentId,
            @RequestParam Department newDepartment) {
        return studentservice.updateStudentDepartment(studentId, newDepartment);
    }






}
