package com.company;

import java.io.Serializable;

public class Teacher extends Person implements Serializable{
    private String status;

    public Teacher(String name, String profile, int id, String status) {
        super(name, profile, id);
        this.status = status;
    }

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
