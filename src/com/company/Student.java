package com.company;

public class Student extends Person {
    private String course;

    public Student(String name, String profile, int id, String course) {
        super(name, profile, id);
        this.course = course;
    }

    String type() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
