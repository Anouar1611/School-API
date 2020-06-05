package com.example.API.demo.Repo;


import com.example.API.demo.Models.Groups;
import com.example.API.demo.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Groups, Long> {
}
