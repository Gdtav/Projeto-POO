package com.company;

import java.io.Serializable;

/**
 * The type Signup. This class is a wrapper for a person/location pair
 */
public class Signup implements Serializable{
    private Person attendee;
    private Location location;

    /**
     * Instantiates a new Signup.
     *
     * @param attendee the attendee
     * @param location the location
     */
    public Signup(Person attendee, Location location) {
        this.attendee = attendee;
        this.location = location;
    }

    /**
     * Gets attendee.
     *
     * @return the attendee
     */
    public Person getAttendee() {
        return attendee;
    }

    /**
     * Sets attendee.
     *
     * @param attendee the attendee
     */
    public void setAttendee(Person attendee) {
        this.attendee = attendee;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }
}
