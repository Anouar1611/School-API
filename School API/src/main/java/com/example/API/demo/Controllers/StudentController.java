package com.example.API.demo.Controllers;


import com.example.API.demo.Models.Student;
import com.example.API.demo.Models.Subject;
import com.example.API.demo.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping(value = "/student")
    public ResponseEntity<List<Student>> showAllStudent() {
        return ResponseEntity.ok(studentRepo.findAll());
    }

    @GetMapping(value = "/student/{id}")
    public Student studentById(@PathVariable long id) {
        return studentRepo.findById(id).get();
    }

    @PostMapping(value = "/poststudent")
    public void addstudent(@RequestBody Student student){
        student.getMarks().forEach(m -> m.setStudent(student));
        studentRepo.save(student);}

    @DeleteMapping(value = "/student/{id}")
    public void deleteStudent(@PathVariable long id) { studentRepo.deleteById(id); }
}
