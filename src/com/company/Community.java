package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Community.
 */
public abstract class Community implements Serializable{
    private ArrayList<Person> people;

    /**
     * Add a person to the community's ArrayList<> people.
     *
     * @param person the person
     */
    public void addPerson(Person person) {
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
    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    /**
     * Instantiates a new Community.
     *
     * @param people the people
     */
    public Community(ArrayList<Person> people) {
        this.people = people;
    }

    /**
     * Instantiates a new Community.
     */
    public Community() {
    }
}
