package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Signups. This class manages the Signup pairs.
 */
public class Signups implements Serializable{
    private java.util.ArrayList<Signup> pairs;

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
     * @param percent the percent
     * @return the array list
     */
    ArrayList<Person> guestList(Bar bar, double percent) {
        int size = (int) Math.floor(bar.getCapacity() * percent);
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
     * Gets the number of people signed up.
     *
     * @param location the location
     * @return the num signups
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
        return getNumSignups(location) < location.getCapacity();
    }
}
