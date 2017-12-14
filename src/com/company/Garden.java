package com.company;

import java.io.Serializable;

public class Garden extends Location implements Serializable{
    private double area;

    public Garden(String name, float lat, float lon, double area) {
        super(name, lat, lon, 0, 0);
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nArea: " + area + "m²";
    }

    public String type() {
        return "Garden";
    }
}
