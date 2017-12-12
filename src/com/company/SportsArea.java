package com.company;

import java.util.ArrayList;

public class SportsArea extends Location {
    private ArrayList<String> sports;

    public SportsArea(String name, float lat, float lon, ArrayList<String> sports) {
        super(name, lat, lon, 0, 0);
        this.sports = sports;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(super.toString() + "Sports:");
        for (String sport : sports)
            str.append("\n- ").append(sport);
        return str.toString();
    }

    public String type() {
        return "Sports Area";
    }
}
