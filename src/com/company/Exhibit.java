package com.company;

public class Exhibit extends Location {
    private String category;

    public Exhibit(String name, float lat, float lon, String category) {
        super(name, lat, lon, 0, 0);
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCategory: " + category +
                "\nEntry fee: " + getPrice() + "€";
    }

    public String type() {
        return "Exhibit";
    }
}
