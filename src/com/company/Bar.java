package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Bar.
 */
public class Bar extends Location implements Serializable {

    /**
     * Instantiates a new Bar.
     *
     * @param name     the name
     * @param lat      the latitude
     * @param lon      the longitude
     * @param capacity the capacity
     * @param price    the entry fee
     */
    public Bar(String name, float lat, float lon, int capacity, int price) {
        super(name, lat, lon, capacity, price);
    }

    @Override
    public String attributes() {
        return super.attributes() +
                "\nLotação: " + getCapacity() +
                "\nTaxa de entrada: " + getPrice() + "€";
    }

    public String type() {
        return "Bar";
    }
}
