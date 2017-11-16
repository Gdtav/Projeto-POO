package com.company;

import java.util.ArrayList;

public class Garden extends Location {
    private float area;

    public Garden(String name, ArrayList<Person> attendees, float lat, float lon, float area) {
        super(name, attendees, lat, lon);
        this.area = area;
    }

    public Garden(String name, float lat, float lon, float area) {
        super(name, lat, lon);
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
