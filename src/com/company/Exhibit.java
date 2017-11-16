package com.company;

import java.util.ArrayList;

public class Exhibit extends Location {
    private String type;
    private float price;

    public Exhibit(String name, ArrayList<Person> attendees, float lat, float lon, String type, float price) {
        super(name, attendees, lat, lon);
        this.type = type;
        this.price = price;
    }

    public Exhibit(String name, float lat, float lon, String type, float price) {
        super(name, lat, lon);
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
