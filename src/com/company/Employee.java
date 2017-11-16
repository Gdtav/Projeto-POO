package com.company;

public class Employee extends Person {
    private String regime;

    public Employee(String name, String profile, int id, String regime) {
        super(name, profile, id);
        this.regime = regime;
    }

    String type() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
