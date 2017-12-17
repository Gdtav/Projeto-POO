package com.company;

import java.io.Serializable;

/**
 * The type Location. This is an abstract class to hold common locations' elements.
 */
public abstract class Location implements Serializable {
    private String name;
    private float lat;
    private float lon;
    private int capacity;
    private double price;

    /**
     * Instantiates a new Location.
     *
     * @param name     the name
     * @param lat      the lat
     * @param lon      the lon
     * @param capacity the capacity
     * @param price    the price
     */
    Location(String name, float lat, float lon, int capacity, int price) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.capacity = capacity;
        this.price = price;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets latitude.
     *
     * @return the lat
     */
    private float getLat() {
        return lat;
    }

    /**
     * Gets longitude.
     *
     * @return the lon
     */
    private float getLon() {
        return lon;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return type() + " - " + name;
    }

    /**
     * Attributes string.
     *
     * @return the string
     */
    public String attributes() {
        return "Nome: " + getName() +
                "\nGPS: " + getLon() + ", " + getLat() +
                "\nTipo: " + type()
                ;
    }

    /**
     * Type string.
     *
     * @return the string
     */
    public abstract String type();
}
