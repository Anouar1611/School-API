package com.example.API.demo.Controllers;


import com.example.API.demo.Models.Groups;
import com.example.API.demo.Models.Student;
import com.example.API.demo.Models.SubjectTeacher;
import com.example.API.demo.Models.Teacher;
import com.example.API.demo.Repo.SubjectTeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectTeacherController {

    @Autowired
    SubjectTeacherRepo subjectTeacherRepo;

    @GetMapping(value = "/subject_teacher")
    public ResponseEntity<List<SubjectTeacher>> showAll() { return ResponseEntity.ok(subjectTeacherRepo.findAll()); }

    @GetMapping(value = "/subject_teacher/group/{id}")
    public Groups getgroupById(@PathVariable long id){
        return subjectTeacherRepo.findById(id).get().getGroupp();
    }

}
