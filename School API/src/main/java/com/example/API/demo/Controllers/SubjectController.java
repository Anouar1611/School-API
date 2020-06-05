package com.example.API.demo.Controllers;

import com.example.API.demo.Models.Subject;
import com.example.API.demo.Models.Teacher;
import com.example.API.demo.Repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    SubjectRepo subjectRepo;

    @GetMapping(value = "/subject")
    public ResponseEntity<List<Subject>> showAllSubjects() {
        return ResponseEntity.ok(subjectRepo.findAll());
    }

    @GetMapping(value = "/subject/{id}")
    public Subject subjectById(@PathVariable long id) {
        return subjectRepo.findById(id).get();
    }

    @PostMapping(value = "/postsubject")
    public void addsubject(@RequestBody Subject subject){
        subject.getLitsmark().forEach(x -> x.setSubject(subject));
        subject.getListsubjectTeacher().forEach(z -> z.setSubjectt(subject));
        subjectRepo.save(subject);}

    @DeleteMapping(value = "/subject/{id}")
    public void deleteSubject(@PathVariable long id) { subjectRepo.deleteById(id); }
}
