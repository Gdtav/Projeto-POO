package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Signups implements Serializable{
    private java.util.ArrayList<Signup> pairs;

    void addSignup(Signup signup) {
        pairs.add(signup);
    }

    ArrayList<Person> getAttendees(Location location) {
        return null;
    }

    ArrayList<Location> getSignups(Person attendee) {
        return null;
    }

    double getRevenue(Location location) {
        return location.getPrice() * getNumSignups(location);
    }

    boolean checkExist(Signup signup) {
        for (Signup sign : pairs) {
            if (sign.getLocation() == sign.getLocation() && sign.getAttendee() == signup.getAttendee())
                return true;
        }
        return false;
    }

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

    int getNumSignups(Location location) {
        int count = 0;
        for (Signup signup : pairs) {
            if (signup.getLocation() == location)
                count++;
        }
        return count;
    }

    boolean isFull(Location location) {
        return getNumSignups(location) < location.getCapacity();
    }
}
