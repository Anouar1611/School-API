package com.example.API.demo.Controllers;

import com.example.API.demo.Models.Subject;
import com.example.API.demo.Models.Teacher;
import com.example.API.demo.Repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/SchoolAPI")
class TeacherController {

    @Autowired
    TeacherRepo teacherRepo;

    @GetMapping(value = "/teacher")
    public List<Teacher> showAllTeachers() {
        return teacherRepo.findAll();
    }

    @GetMapping(value = "/teacher/{id}")
    public Teacher teacherById(@PathVariable long id) {
        return teacherRepo.findById(id).get();
    }

    @PostMapping(value = "/posteacher")
    public void addteacher(@RequestBody Teacher teacher){
        //teacher.getListsubjectTeachers().forEach(s -> s.setTeacher(teacher));
        teacherRepo.save(teacher);}

    @DeleteMapping(value = "/teacher/{id}")
    public void deleteTeacher(@PathVariable long id) { teacherRepo.deleteById(id); }



}