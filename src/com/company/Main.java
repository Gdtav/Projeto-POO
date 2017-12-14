package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Mixer mixer;
        LoginWindow loginWindow;
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Student("joão", "banana", 123, "eng inf"));
        personArrayList.add(new Student("joana", "banana", 124, "eng inf"));
        mixer = new Mixer(personArrayList, new ArrayList<>());
        loginWindow = new LoginWindow("bananas", mixer);
    }
}
