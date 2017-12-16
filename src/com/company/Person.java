package com.company;

import java.util.ArrayList;

/**
 * The type Person. this is an abstract class to hold common people's elements.
 */
public abstract class Person{
    private String name;
    private String profile;
    private String password = null;
    private int id;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     * Sets profile.
     *
     * @param profile the profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Instantiates a new Person.
     *
     * @param name    the name
     * @param profile the profile
     * @param id      the id
     */
    public Person(String name, String profile, int id) {
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
    public Person(String name, String profile, String password, int id) {
        this.name = name;
        this.profile = profile;
        this.password = password;
        this.id = id;
    }

    /**
     * Signups up person to the mixer.
     *
     * @param mixer    the mixer
     * @param password the password
     */
    void signupMixer(Mixer mixer, String password) {
        mixer.addPerson(this);
    }

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
