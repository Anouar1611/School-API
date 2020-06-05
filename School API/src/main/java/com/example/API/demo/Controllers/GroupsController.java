package com.example.API.demo.Controllers;

import com.example.API.demo.Models.Groups;
import com.example.API.demo.Models.Subject;
import com.example.API.demo.Repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupsController {

    @Autowired
    GroupRepo groupRepo;

    @GetMapping(value = "/group")
    public ResponseEntity<List<Groups>> showAllGroups() {
        return ResponseEntity.ok(groupRepo.findAll());
    }

    @GetMapping(value = "/group/{id}")
    public Groups groupById(@PathVariable long id) {
        return groupRepo.findById(id).get();
    }

    @PostMapping(value = "/postgroup")
    public void addgroup(@RequestBody Groups groups){
        groups.getStudents().forEach(s -> s.setGroup(groups));
        groups.getSubjectTeachers().forEach(x -> x.setGroupp(groups));
        groupRepo.save(groups);}

    @DeleteMapping(value = "/group/{id}")
    public void deleteGroup(@PathVariable long id) { groupRepo.deleteById(id); }
}
