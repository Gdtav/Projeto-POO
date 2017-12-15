package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Mixer extends Community implements Serializable {
    private ArrayList<Location> locations;
    private Signups signups;

    public ArrayList<Location> getLocations() {
        return locations;
    }

    boolean loginCheck(int id, String pw) {
        for (Person person : getPeople()) {
            if (person.getId() == id) {
                if (person.getPassword().equals(pw))
                    return true;
                break;
            }
        }
        return false;
    }

    public ArrayList<Person> getSignedUp() {
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : getPeople()) {
            if (person.getPassword() != null) people.add(person);
        }
        return people;
    }

    public ArrayList<Location> getFreeLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        for (Location location : getLocations()) {
            if (signups.getNumSignups(location) < location.getCapacity()) locations.add(location);
        }
        return locations;
    }

    public ArrayList<Bar> getBars() {
        ArrayList<Bar> bars = new ArrayList<>();
        for (Location location : locations) {
            if (location.type().equals("Bar")) {
                bars.add((Bar) location);
            }
        }
        return bars;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public Signups getSignups() {
        return signups;
    }

    public void setSignups(Signups signups) {
        this.signups = signups;
    }

    public Mixer() {
    }

    public Mixer(ArrayList<Person> people, ArrayList<Location> locations, Signups signups) {
        super(people);
        this.locations = locations;
        this.signups = signups;
    }

    String showLocations() {
        return null;
    }

    void sortLocations() {
        getLocations().sort(new Comparator<Location>() {
            @Override
            public int compare(Location location, Location t1) {
                return signups.getNumSignups(location) - signups.getNumSignups(t1);
            }
        });
    }

    double minRevenue() {
        double revenue = 0;
        for (Location location : locations) {
            revenue += signups.getRevenue(location);
        }
        return revenue;
    }

    boolean signupLocation(Person person, Location location) {
        if (location.getCapacity() == 0 || signups.getNumSignups(location) < location.getCapacity()) {
            signups.addSignup(new Signup(person, location));
            return true;
        }
        return false;
    }
}
