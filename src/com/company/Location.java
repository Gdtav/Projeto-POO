package com.company;

import java.io.Serializable;

/**
 * The type Location. This is an abstract class to hold common locations' elements.
 */
public abstract class Location implements Serializable{
    private String name;
    private float lat;
    private float lon;
    private int capacity;
    private double price;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets lat.
     *
     * @return the lat
     */
    public float getLat() {
        return lat;
    }

    /**
     * Sets lat.
     *
     * @param lat the lat
     */
    public void setLat(float lat) {
        this.lat = lat;
    }

    /**
     * Gets lon.
     *
     * @return the lon
     */
    public float getLon() {
        return lon;
    }

    /**
     * Sets lon.
     *
     * @param lon the lon
     */
    public void setLon(float lon) {
        this.lon = lon;
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
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Instantiates a new Location.
     *
     * @param name     the name
     * @param lat      the lat
     * @param lon      the lon
     * @param capacity the capacity
     * @param price    the price
     */
    public Location(String name, float lat, float lon, int capacity, int price) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public String toString() {
        return type() + " - " + name;
    }

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
