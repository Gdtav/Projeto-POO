package com.company;

import java.io.Serializable;

/**
 * The type Student.
 */
public class Student extends Person implements Serializable {
    private String course;

    /**
     * Instantiates a new Student.
     *
     * @param name    the name
     * @param profile the profile
     * @param id      the id
     * @param course  the course
     */
    Student(String name, String profile, int id, String course) {
        super(name, profile, id);
        this.course = course;
    }

    public String type() {
        return "Estudante";
    }

    @Override
    public String attributes() {
        return super.attributes() +
                "\nCurso: " + course;
    }
}
