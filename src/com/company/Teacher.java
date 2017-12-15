package com.company;

import java.io.Serializable;

/**
 * The type Teacher.
 */
public class Teacher extends Person implements Serializable{
    private String status;

    /**
     * Instantiates a new Teacher.
     *
     * @param name    the name
     * @param profile the profile
     * @param id      the id
     * @param status  the status
     */
    public Teacher(String name, String profile, int id, String status) {
        super(name, profile, id);
        this.status = status;
    }

    /**
     * Instantiates a new Teacher (if password is set).
     *
     * @param name     the name
     * @param profile  the profile
     * @param password the password
     * @param id       the id
     * @param status   the status
     */
    public Teacher(String name, String profile, String password, int id, String status) {
        super(name, profile, password, id);
        this.status = status;
    }

    public String type() {
        return "Teacher";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nStatus: " + status;
    }
}
