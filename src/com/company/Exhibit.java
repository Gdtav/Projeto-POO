package com.company;

import java.io.Serializable;

/**
 * The type Exhibit.
 */
public class Exhibit extends Location implements Serializable {
    private String category;

    /**
     * Instantiates a new Exhibit.
     *
     * @param name     the name
     * @param lat      the latitude
     * @param lon      the longitude
     * @param price    the price
     * @param category the category of the exhibit
     */
    public Exhibit(String name, float lat, float lon, int price, String category) {
        super(name, lat, lon, 0, price);
        this.category = category;
    }

    @Override
    public String attributes() {
        return super.attributes() +
                "\nCategoria: " + category +
                "\nTaxa de entrada: " + getPrice() + "€";
    }

    public String type() {
        return "Exposição";
    }
}
