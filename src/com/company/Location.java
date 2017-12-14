package com.company;

import java.io.Serializable;

public abstract class Location{
    private String name;
    private float lat;
    private float lon;
    private int capacity;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Location(String name, float lat, float lon, int capacity, int price) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nGPS: " + lat + ", " + lon +
                "\nType: " + type();
    }

    public abstract String type();
}
