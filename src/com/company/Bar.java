package com.company;

import java.util.ArrayList;

public class Bar extends Location {
    private int capacity;
    private float fee;

    public Bar(String name, ArrayList<Person> attendees, float lat, float lon, int capacity, float fee) {
        super(name, attendees, lat, lon);
        this.capacity = capacity;
        this.fee = fee;
    }

    public Bar(String name, float lat, float lon, int capacity, float fee) {
        super(name, lat, lon);
        this.capacity = capacity;
        this.fee = fee;
    }

    ArrayList<Person> guestList() {
        return null;
    }

    boolean isFull() {
        return false;
    }

    String showSignupNum() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
