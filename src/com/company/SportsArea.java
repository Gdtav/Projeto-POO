package com.company;

import java.util.ArrayList;

public class SportsArea extends Location {
    private java.util.ArrayList<String> sports;

    public SportsArea(String name, ArrayList<Person> attendees, float lat, float lon, ArrayList<String> sports) {
        super(name, attendees, lat, lon);
        this.sports = sports;
    }

    public SportsArea(String name, float lat, float lon, ArrayList<String> sports) {
        super(name, lat, lon);
        this.sports = sports;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
