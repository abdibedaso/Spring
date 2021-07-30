package com.geekcolab.development.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long courseNumber;
    private String name;
    private String grade;

    public Course(long courseNumber, String name, String grade) {
        this.courseNumber = courseNumber;
        this.name = name;
        this.grade = grade;
    }

    public Course() {
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public long getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(long courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "courseNumber=" + courseNumber + ", name=" + name + ", grade=" + grade + "\n";
    }

}
