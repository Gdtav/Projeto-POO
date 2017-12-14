package com.company;

import java.util.ArrayList;

public abstract class Person{
    private String name;
    private String profile;
    private String password = null;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String name, String profile, int id) {
        this.name = name;
        this.profile = profile;
        this.id = id;
    }

    public Person(String name, String profile, String password, int id) {
        this.name = name;
        this.profile = profile;
        this.password = password;
        this.id = id;
    }

    void signupMixer(Mixer mixer, String password) {
        mixer.addPerson(this);
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nProfile: " + getProfile() +
                "\nID: " + getId() +
                "\nType: " + type();
    }

    public abstract String type();

}
