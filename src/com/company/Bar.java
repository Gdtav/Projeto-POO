package com.company;

import java.io.Serializable;

/**
 * The type Bar.
 */
public class Bar extends Location implements Serializable {
    private double capacityPercent;

    /**
     * Instantiates a new Bar.
     *
     * @param name            the name
     * @param lat             the latitude
     * @param lon             the longitude
     * @param capacity        the capacity
     * @param price           the entry fee
     * @param capacityPercent Percentage of capacity to get into guestlist
     */
    public Bar(String name, float lat, float lon, int capacity, int price, double capacityPercent) {
        super(name, lat, lon, capacity, price);
        this.capacityPercent = capacityPercent;
    }

    /**
     * Gets percentage of people for the guest list.
     *
     * @return the capacity percentage
     */
    public double getCapacityPercent() {
        return capacityPercent;
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
