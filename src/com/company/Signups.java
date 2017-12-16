package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Signups. This class manages the Signup pairs.
 */
public class Signups implements Serializable{
    private java.util.ArrayList<Signup> pairs = new ArrayList<>();

    /**
     * Add signup.
     *
     * @param signup the signup
     */
    void addSignup(Signup signup) {
        pairs.add(signup);
    }

    /**
     * Gets attendees.
     *
     * @param location the location
     * @return the attendees
     */
    ArrayList<Person> getAttendees(Location location) {
        return null;
    }

    /**
     * Gets signups.
     *
     * @param attendee the attendee
     * @return the signups
     */
    ArrayList<Location> getSignups(Person attendee) {
        return null;
    }

    /**
     * Gets revenue.
     *
     * @param location the location
     * @return the revenue
     */
    double getRevenue(Location location) {
        return location.getPrice() * getNumSignups(location);
    }

    /**
     * Checks if signup already exists.
     *
     * @param signup the signup
     * @return True if it exists
     */
    boolean checkExist(Signup signup) {
        for (Signup sign : pairs) {
            if (sign.getLocation() == sign.getLocation() && sign.getAttendee() == signup.getAttendee())
                return true;
        }
        return false;
    }

    /**
     * Generates the guest list for the bar.
     *
     * @param bar     the bar
     * @return the array list
     */
    ArrayList<Person> guestList(Bar bar) {
        int size = (int) Math.floor(bar.getCapacity() * bar.getCapacityPercent());
        int index = 0;
        ArrayList<Person> people = new ArrayList<>();
        for (Signup signup : pairs) {
            if (signup.getLocation() == bar) {
                if (signup.getAttendee().getProfile().equals("Boémio")) {
                    people.add(index, signup.getAttendee());
                    if (people.size() > size) people.remove(size);
                    index++;
                } else if (people.size() < size)
                    people.add(signup.getAttendee());
            }
            if (index == size) break;
        }
        return people;
    }

    /**
     * Get person signups array list.
     *
     * @param person the person
     * @return the array list
     */
    ArrayList<Signup> getPersonSignups(Person person){
        ArrayList<Signup> signups = new ArrayList<>();
        for (Signup signup:pairs)
            if(person == signup.getAttendee()) signups.add(signup);
        return signups;
    }

    /**
     * Remove the signups of the person.
     *
     * @param person the person
     */
    void removePersonSignups(Person person){
        pairs.removeAll(getPersonSignups(person));
    }

    /**
     * Gets number of signups in the specified location.
     *
     * @param location the location
     * @return the number signups
     */
    int getNumSignups(Location location) {
        int count = 0;
        for (Signup signup : pairs) {
            if (signup.getLocation() == location)
                count++;
        }
        return count;
    }

    /**
     * Checks if the location is full.
     *
     * @param location the location
     * @return True if is full
     */
    boolean isFull(Location location) {
        return location.getCapacity() != 0 && getNumSignups(location) == location.getCapacity();
    }
}
