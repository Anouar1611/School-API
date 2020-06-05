package com.example.API.demo.Models;

import com.example.API.demo.Models.SubjectTeacher;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    private List<Mark> litsmark = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "subjectt",cascade = CascadeType.ALL)
    private List<SubjectTeacher> listsubjectTeacher = new ArrayList<>();

    public Subject() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Mark> getLitsmark() {
        return litsmark;
    }

    public void setLitsmark(List<Mark> litsmark) {
        this.litsmark = litsmark;
    }

    public List<SubjectTeacher> getListsubjectTeacher() {
        return listsubjectTeacher;
    }

    public void setListsubjectTeacher(List<SubjectTeacher> listsubjectTeacher) {
        this.listsubjectTeacher = listsubjectTeacher;
    }
}