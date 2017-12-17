package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Sports area.
 */
public class SportsArea extends Location implements Serializable {
    private ArrayList<String> sports;

    /**
     * Instantiates a new Sports area.
     *
     * @param name   the name
     * @param lat    the lat
     * @param lon    the lon
     * @param sports the sports
     */
    SportsArea(String name, float lat, float lon, ArrayList<String> sports) {
        super(name, lat, lon, 0, 0);
        this.sports = sports;
    }

    @Override
    public String attributes() {
        StringBuilder str = new StringBuilder(super.attributes() + "\nDesportos:");
        for (String sport : sports)
            str.append("\n- ").append(sport);
        return str.toString();
    }

    public String type() {
        return "Área de desporto";
    }
}
