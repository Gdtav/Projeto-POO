package com.company;

import java.util.ArrayList;

public class Mixer extends Community {
    private java.util.ArrayList<Location> locations;

    public Mixer(ArrayList<Person> people, ArrayList<Location> locations) {
        super(people);
        this.locations = locations;
    }

    String showLocations() {
        return null;
    }

    void sortLocations() {
    }

    double minRevenue() {
        return 0;
    }

    void addAttendee(Person person) {
    }

    void signupLocation(Person person, Location location) {
    }
}
