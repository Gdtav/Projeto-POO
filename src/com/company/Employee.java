package com.company;

import java.io.Serializable;

/**
 * The type Employee.
 */
public class Employee extends Person implements Serializable {
    private String regime;

    /**
     * Instantiates a new Employee.
     *
     * @param name    the name
     * @param profile the profile
     * @param id      the id number
     * @param regime  the regime (Full-time or part-time)
     */
    Employee(String name, String profile, int id, String regime) {
        super(name, profile, id);
        this.regime = regime;
    }

    public String type() {
        return "Funcionário";
    }

    @Override
    public String attributes() {
        return super.attributes() +
                "\nRegime: " + regime;
    }
}
