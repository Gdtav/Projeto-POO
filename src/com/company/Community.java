package com.company;

import java.util.ArrayList;

public class Community {
    private ArrayList<Person> people;

    void addPerson(Person person) {
        people.add(person);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public Community(ArrayList<Person> people) {
        this.people = people;
    }
}
