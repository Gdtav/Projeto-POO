package com.company;

import java.io.Serializable;

/**
 * The type Person. this is an abstract class to hold common people's elements.
 */
public abstract class Person implements Serializable {
    private String name;
    private String profile;
    private String password = null;
    private int id;

    /**
     * Instantiates a new Person.
     *
     * @param name    the name
     * @param profile the profile
     * @param id      the id
     */
    Person(String name, String profile, int id) {
        this.name = name;
        this.profile = profile;
        this.id = id;
    }

    /**
     * Instantiates a new Person.
     *
     * @param name     the name
     * @param profile  the profile
     * @param password the password
     * @param id       the id
     */
    Person(String name, String profile, String password, int id) {
        this.name = name;
        this.profile = profile;
        this.password = password;
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets profile.
     *
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Attributes string.
     *
     * @return the string
     */
    public String attributes() {
        return "Nome: " + getName() +
                "\nPerfil: " + getProfile() +
                "\nID: " + getId() +
                "\nTipo: " + type();
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }

    /**
     * Type string.
     *
     * @return the string
     */
    public abstract String type();

}
