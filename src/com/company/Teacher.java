package com.company;

public class Teacher extends Person {
    private String status;

    public Teacher(String name, String profile, int id, String status) {
        super(name, profile, id);
        this.status = status;
    }

    String type() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
