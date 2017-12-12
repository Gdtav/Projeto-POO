package com.company;

public class Employee extends Person {
    private String regime;

    public Employee(String name, String profile, int id, String regime) {
        super(name, profile, id);
        this.regime = regime;
    }

    public Employee(String name, String profile, String password, int id, String regime) {
        super(name, profile, password, id);
        this.regime = regime;
    }

    public String type() {
        return "Employee";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRegime: " + regime;
    }
}
