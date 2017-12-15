package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The type Mixer. This is the main class which manages the whole event
 */
public class Mixer extends Community implements Serializable {
    private ArrayList<Location> locations;
    private Signups signups = new Signups();

    /**
     * Gets locations.
     *
     * @return the locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Login check.
     *
     * @param id the id of the person
     * @param pw the password
     * @return True if the password is correct
     */
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

    /**
     * Gets the list of people wwho are signed up in the event.
     *
     * @return the signed up
     */
    public ArrayList<Person> getSignedUp() {
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : getPeople()) {
            if (person.getPassword() != null) people.add(person);
        }
        return people;
    }

    /**
     * Gets the locations that aren't full.
     *
     * @return those locations
     */
    public ArrayList<Location> getFreeLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        for (Location location : getLocations()) {
            if (!signups.isFull(location)) locations.add(location);
        }
        return locations;
    }

    /**
     * Gets bars.
     *
     * @return the bars
     */
    public ArrayList<Bar> getBars() {
        ArrayList<Bar> bars = new ArrayList<>();
        for (Location location : locations) {
            if (location.type().equals("Bar")) {
                bars.add((Bar) location);
            }
        }
        return bars;
    }

    /**
     * Sets locations.
     *
     * @param locations the locations
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Gets signup managing class.
     *
     * @return signups signups
     */
    public Signups getSignups() {
        return signups;
    }

    /**
     * Sets signups.
     *
     * @param signups the signups
     */
    public void setSignups(Signups signups) {
        this.signups = signups;
    }

    /**
     * Instantiates a new Mixer.
     */
    public Mixer() {
    }

    /**
     * Instantiates a new Mixer.
     *
     * @param people    the people
     * @param locations the locations
     * @param signups   the signups
     */
    public Mixer(ArrayList<Person> people, ArrayList<Location> locations, Signups signups) {
        super(people);
        this.locations = locations;
        this.signups = signups;
    }

    /**
     * Show locations string.
     *
     * @return the string
     */
    String showLocations() {
        return null;
    }

    /**
     * Sort locations.
     *
     * @param list the list
     */
    void sortLocations(ArrayList<Location> list) {
        list.sort(new Comparator<Location>() {
            @Override
            public int compare(Location location, Location location1) {
                return signups.getNumSignups(location) - signups.getNumSignups(location1);
            }
        });
    }

    /**
     * Calculates the minimum revenue expected.
     *
     * @return the expected revenue
     */
    double minRevenue() {
        double revenue = 0;
        for (Location location : locations) {
            revenue += signups.getRevenue(location);
        }
        return revenue;
    }

    /**
     * Checks if a person is signed up to a location.
     *
     * @param person   the person
     * @param location the location
     * @return True or False
     */
    boolean signupLocation(Person person, Location location) {
        if (location.getCapacity() == 0 || signups.getNumSignups(location) < location.getCapacity()) {
            signups.addSignup(new Signup(person, location));
            return true;
        }
        return false;
    }
}
