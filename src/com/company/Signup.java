package com.company;

import java.io.Serializable;

public class Signup implements Serializable{
    private Person attendee;
    private Location location;

    public Signup(Person attendee, Location location) {
        this.attendee = attendee;
        this.location = location;
    }

    public Person getAttendee() {
        return attendee;
    }

    public void setAttendee(Person attendee) {
        this.attendee = attendee;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
