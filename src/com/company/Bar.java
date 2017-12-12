package com.company;

import java.util.ArrayList;

public class Bar extends Location {

    public Bar(String name, float lat, float lon, int capacity, int price) {
        super(name, lat, lon, capacity, price);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCapacity: " + getCapacity() +
                "\nEntry fee: " + getPrice() + "€";
    }

    public String type() {
        return "Bar";
    }
}
