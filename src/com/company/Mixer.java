package com.company;

import java.util.ArrayList;

public class Mixer extends Community {
    private ArrayList<Location> locations;
    private Signups signups;

    public ArrayList<Location> getLocations() {
        return locations;
    }

    boolean loginCheck(int id, String pw){
        for (Person person: getPeople()) {
            if (person.getId() == id){
                if (person.getPassword().equals(pw))
                    return true;
                break;
            }
        }
        return false;
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

    public Mixer(ArrayList<Person> people, ArrayList<Location> locations) {
        super(people);
        this.locations = locations;
    }

    String showLocations() {
        return null;
    }

    void sortLocations() {
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
