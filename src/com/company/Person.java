package com.company;

import java.util.ArrayList;

public class Person {
    private String name;
    private String profile;
    private String password;
    private java.util.ArrayList<Location> signups;
    private int id;

    public Person(String name, String profile, int id) {
        this.name = name;
        this.profile = profile;
        this.id = id;
    }

    void signupMixer(Mixer mixer, String password) {
    }

    boolean addLocation(Location location) {
        return false;
    }

    String type() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
