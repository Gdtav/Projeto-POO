package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Mixer mixer;
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personArrayList.add(new Student("joão", "banana", 123, "eng inf"));
            personArrayList.add(new Student("joana", "banana", 123, "eng inf"));
        }
        mixer = new Mixer(personArrayList, new ArrayList<>());
        JFrame frame = new JFrame("LoginWindow");
        frame.setContentPane(new LoginWindow(mixer.getPeople()).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
