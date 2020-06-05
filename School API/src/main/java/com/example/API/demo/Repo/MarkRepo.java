package com.example.API.demo.Repo;


import com.example.API.demo.Models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MarkRepo extends JpaRepository<Mark,Long> {
}
