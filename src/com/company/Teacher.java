package com.company;

import java.io.Serializable;

/**
 * The type Teacher.
 */
public class Teacher extends Person implements Serializable {
    private String status;

    /**
     * Instantiates a new Teacher.
     *
     * @param name    the name
     * @param profile the profile
     * @param id      the id
     * @param status  the status
     */
    Teacher(String name, String profile, int id, String status) {
        super(name, profile, id);
        this.status = status;
    }

    public String type() {
        return "Professor";
    }

    @Override
    public String attributes() {
        return super.attributes() +
                "\nEstatuto: " + status;
    }
}
