package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.exit;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Mixer mixer = new Mixer();
        ObjectFile objectFile = new ObjectFile();
        try {
            objectFile.openRead("Mixer.obj");
            try {
                mixer = (Mixer) objectFile.readObject();
            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
                exit(1);
            }
            objectFile.closeRead();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Não foi possivel ler os ficheiros objeto. A abrir ficheiros de texto...");
            String []strings;
            String string;
            ArrayList<Location> locationArrayList = new ArrayList<>();
            //abrir os textos para ler pessoas
            textFile students = new textFile();
            textFile teachers = new textFile();
            textFile employees = new textFile();
            //abrir os textos para ler locais
            textFile gardens = new textFile();
            textFile bars = new textFile();
            textFile sports = new textFile();
            textFile exhibits = new textFile();
            try {
                students.openRead("students.txt");
                while ((string = students.readLine()) != null) {
                    strings = string.split(",");
                    Person person = new Student(strings[0],strings[1],Integer.parseInt(strings[2]),strings[3]);
                    System.out.println(person);
                    mixer.addPerson(person);

                }
                students.closeRead();
                teachers.openRead("teachers.txt");
                while ((string = teachers.readLine()) != null) {
                    strings = string.split(",");
                    mixer.addPerson(new Teacher(strings[0],strings[1],Integer.parseInt(strings[2]),strings[3]));
                }
                teachers.closeRead();
                employees.openRead("employees.txt");
                while ((string = employees.readLine()) != null) {
                    strings = string.split(",");
                    mixer.addPerson(new Employee(strings[0],strings[1],Integer.parseInt(strings[2]),strings[3]));
                }
                employees.closeRead();
                gardens.openRead("gardens.txt");
                while ((string = gardens.readLine()) != null) {
                    strings = string.split(",");
                    locationArrayList.add(new Garden(strings[0],Float.parseFloat(strings[1]),Float.parseFloat(strings[2]),Double.parseDouble(strings[3])));
                }
                gardens.closeRead();
                bars.openRead("bars.txt");
                while ((string = bars.readLine()) != null) {
                    strings = string.split(",");
                    locationArrayList.add(new Bar(strings[0],Float.parseFloat(strings[1]),Float.parseFloat(strings[2]),Integer.parseInt(strings[3]),Integer.parseInt(strings[4]),Double.parseDouble(strings[5])));
                }
                bars.closeRead();
                sports.openRead("sports.txt");
                while ((string = sports.readLine()) != null) {
                    strings = string.split(",");
                    locationArrayList.add(new SportsArea(strings[0],Float.parseFloat(strings[1]),Float.parseFloat(strings[2]),new ArrayList<String>(Arrays.asList(strings[3].split(";")))));
                }
                sports.closeRead();
                exhibits.openRead("exhibits.txt");
                while ((string = exhibits.readLine()) != null) {
                    strings = string.split(",");
                    locationArrayList.add(new Exhibit(strings[0],Float.parseFloat(strings[1]),Float.parseFloat(strings[2]),Integer.parseInt(strings[3]),strings[4]));
                }
                exhibits.closeRead();
                mixer.setLocations(locationArrayList);
            } catch (IOException e1) {
                //e1.printStackTrace();
                System.out.println("Não foi possível aceder aos ficheiros de texto! Abortando...");
                exit(1);
            }
        }

        /*ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Bar("Pintos", 0, 0, 20, 5, 0.5));
        locations.add(new Bar("Moelas", 0, 0, 20, 5, 0.6));
        locations.add(new Garden("Parque Verde", 0, 0, 100));
        locations.add(new Garden("Xaroca", 0, 0, 100));
        locations.add(new Garden("Xaroca2", 0, 0, 100));
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Student("joão", "banana", "bananazinha", 123, "eng inf"));
        personArrayList.add(new Student("joana", "banana", 124, "eng inf"));
        mixer = new Mixer(personArrayList,locations, new Signups());
        System.out.println("hue");*/
        //loginWindow = new LoginWindow("bananas", mixer);
        new LoginWindow("bananas", mixer);
        System.out.println("huee");
        try {
            objectFile.openWrite("Mixer.obj");
            objectFile.writeObject(mixer);
            objectFile.closeWrite();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Não foi possivel guardar os dados...");
            exit(1);
        }
    }
}
