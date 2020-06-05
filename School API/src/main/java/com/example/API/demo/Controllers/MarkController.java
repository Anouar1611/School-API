package com.example.API.demo.Controllers;


import com.example.API.demo.Models.Mark;
import com.example.API.demo.Models.Student;
import com.example.API.demo.Repo.MarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarkController {

    @Autowired
    MarkRepo markRepo;

    @GetMapping(value = "/mark")
    public ResponseEntity<List<Mark>> showAllMarks() {
        return ResponseEntity.ok(markRepo.findAll());
    }

    @GetMapping(value = "/mark/{id}")
    public Mark markById(@PathVariable long id) {
        return markRepo.findById(id).get();
    }

    @PostMapping(value = "/postmark")
    public void addmark(@RequestBody Mark mark){ markRepo.save(mark);}

    @DeleteMapping(value = "/mark/{id}")
    public void deleteMark(@PathVariable long id) { markRepo.deleteById(id); }
}
