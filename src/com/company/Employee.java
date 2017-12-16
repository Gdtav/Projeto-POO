package com.company;

import java.io.Serializable;

/**
 * The type Employee.
 */
public class Employee extends Person implements Serializable{
    private String regime;

    /**
     * Instantiates a new Employee.
     *
     * @param name    the name
     * @param profile the profile
     * @param id      the id number
     * @param regime  the regime (Full-time or part-time)
     */
    public Employee(String name, String profile, int id, String regime) {
        super(name, profile, id);
        this.regime = regime;
    }

    /**
     * Instantiates a new Employee.
     *
     * @param name     the name
     * @param profile  the profile
     * @param password the password (if set)
     * @param id       the id
     * @param regime   the regime (Full-time or part-time)
     */
    public Employee(String name, String profile, String password, int id, String regime) {
        super(name, profile, password, id);
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
