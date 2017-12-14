package com.company;

import java.io.Serializable;

public class Student extends Person implements Serializable{
    private String course;

    public Student(String name, String profile, int id, String course) {
        super(name, profile, id);
        this.course = course;
    }

    public Student(String name, String profile, String password, int id, String course) {
        super(name, profile, password, id);
        this.course = course;
    }

    public String type() {
        return "Student";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCourse: " + course;
    }
}
