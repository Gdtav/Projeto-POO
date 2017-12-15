package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Mixer mixer;
        LoginWindow loginWindow;
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Bar("Pintos", 0, 0, 20, 5));
        locations.add(new Bar("Moelas", 0, 0, 20, 5));
        locations.add(new Garden("Parque Verde", 0, 0, 100));
        locations.add(new Garden("Xaroca", 0, 0, 100));
        locations.add(new Garden("Xaroca2", 0, 0, 100));
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Student("joão", "banana", 123, "eng inf"));
        personArrayList.add(new Student("joana", "banana", 124, "eng inf"));
        mixer = new Mixer(personArrayList, locations);
        System.out.println("hue");
        //loginWindow = new LoginWindow("bananas", mixer);
        new LoginWindow("bananas", mixer);
        System.out.println("huee");
    }
}
