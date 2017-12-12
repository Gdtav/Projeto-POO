package com.company;

public class Teacher extends Person {
    private String status;

    public Teacher(String name, String profile, int id, String status) {
        super(name, profile, id);
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
