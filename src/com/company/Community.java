package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Community. This is an abstract class from which Mixer descends.
 */
abstract class Community implements Serializable {
    private ArrayList<Person> people;

    /**
     * Instantiates a new Community.
     *
     * @param people the people
     */
    Community(ArrayList<Person> people) {
        this.people = people;
    }

    /**
     * Instantiates a new Community.
     */
    Community() {
    }

    /**
     * Add person.
     *
     * @param person the person
     */
    void addPerson(Person person) {
        people.add(person);
    }

    /**
     * Gets people.
     *
     * @return the people
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Sets people.
     *
     * @param people the people
     */
    void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}
