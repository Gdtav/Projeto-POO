package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Mixer extends Community implements Serializable {
    private ArrayList<Location> locations;
    private Signups signups = new Signups();

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
            if (!signups.isFull(location)) locations.add(location);
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

    public Mixer(ArrayList<Person> people, ArrayList<Location> locations) {
        super(people);
        this.locations = locations;
    }

    String showLocations() {
        return null;
    }

    void sortLocations(ArrayList<Location> list) {
        int n = list.size();
        Location temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(signups.getNumSignups(list.get(j-1)) > signups.getNumSignups((list.get(j)))){
                    //swap elements
                    temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }

            }
        }
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
