package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Mixer mixer;
        LoginWindow loginWindow;
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personArrayList.add(new Student("joão", "banana", "my_asdasd", 123, "eng inf"));
            personArrayList.add(new Student("joana", "banana", "oguicheiramal", 124, "eng inf"));
        }
        mixer = new Mixer(personArrayList, new ArrayList<>());
        loginWindow = new LoginWindow("bananas", mixer);
        System.out.println("hue");
    }
}
