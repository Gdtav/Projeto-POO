package com.company;

import java.util.ArrayList;

public class Location {
    private String name;
    private ArrayList<Person> attendees;
    private float lat;
    private float lon;

    public Location(String name, ArrayList<Person> attendees, float lat, float lon) {
        this.name = name;
        this.attendees = attendees;
        this.lat = lat;
        this.lon = lon;
    }

    public Location(String name, float lat, float lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.attendees = new ArrayList<>();
    }

    boolean addAttendee(Person person) {
        return false;
    }

    boolean isFull() {
        return false;
    }

    float expRevenue() {
        return 0;
    }

    String showSignupNum() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
