package com.example.API.demo.Models;

import com.example.API.demo.Models.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class SubjectTeacher implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Subject subjectt;

    @ManyToOne
    private Groups groupp;

    public SubjectTeacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubjectt() {
        return subjectt;
    }

    public void setSubjectt(Subject subjectt) {
        this.subjectt = subjectt;
    }

    public Groups getGroupp() {
        return groupp;
    }

    public void setGroupp(Groups groupp) {
        this.groupp = groupp;
    }
}