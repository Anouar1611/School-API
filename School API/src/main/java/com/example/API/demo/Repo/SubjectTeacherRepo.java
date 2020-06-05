package com.example.API.demo.Repo;

import com.example.API.demo.Models.SubjectTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTeacherRepo extends JpaRepository<SubjectTeacher,Long> {
}
