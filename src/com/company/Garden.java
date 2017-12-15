package com.company;

import java.io.Serializable;

/**
 * The type Garden.
 */
public class Garden extends Location implements Serializable{
    private double area;

    /**
     * Instantiates a new Garden.
     *
     * @param name the name
     * @param lat  the latitude
     * @param lon  the longitude
     * @param area the area
     */
    public Garden(String name, float lat, float lon, double area) {
        super(name, lat, lon, 0, 0);
        this.area = area;
    }

    @Override
    public String attributes() {
        return super.attributes() +
                "\nArea: " + area + "m²";
    }

    public String type() {
        return "Jardim";
    }
}
