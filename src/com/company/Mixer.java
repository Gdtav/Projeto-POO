package com.company;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.exit;

/**
 * The type Mixer. This is the main class which manages the whole event
 */
class Mixer extends Community implements Serializable {
    private ArrayList<Location> locations;
    private Signups signups;


    /**
     * Instantiates a new Mixer.
     */
    private Mixer() {
        setPeople(new ArrayList<>());
        setLocations(new ArrayList<>());
        setSignups(new Signups());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Mixer mixer = new Mixer();
        ObjectFile objectFile = new ObjectFile();
        try {
            objectFile.openRead("Mixer");
            try {
                mixer = (Mixer) objectFile.readObject();
            } catch (ClassNotFoundException exception) {
                //exception.printStackTrace();
                exit(1);
            }
            objectFile.closeRead();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Não foi possivel ler os ficheiros objeto. A abrir ficheiros de texto...");
            String[] strings;
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
                    Person person = new Student(strings[0], strings[1], Integer.parseInt(strings[2]), strings[3]);
                    System.out.println(person);
                    mixer.addPerson(person);

                }
                students.closeRead();
                teachers.openRead("teachers.txt");
                while ((string = teachers.readLine()) != null) {
                    strings = string.split(",");
                    mixer.addPerson(new Teacher(strings[0], strings[1], Integer.parseInt(strings[2]), strings[3]));
                }
                teachers.closeRead();
                employees.openRead("employees.txt");
                while ((string = employees.readLine()) != null) {
                    strings = string.split(",");
                    mixer.addPerson(new Employee(strings[0], strings[1], Integer.parseInt(strings[2]), strings[3]));
                }
                employees.closeRead();
                gardens.openRead("gardens.txt");
                while ((string = gardens.readLine()) != null) {
                    strings = string.split(",");
                    locationArrayList.add(new Garden(strings[0], Float.parseFloat(strings[1]), Float.parseFloat(strings[2]), Double.parseDouble(strings[3])));
                }
                gardens.closeRead();
                bars.openRead("bars.txt");
                while ((string = bars.readLine()) != null) {
                    strings = string.split(",");
                    locationArrayList.add(new Bar(strings[0], Float.parseFloat(strings[1]), Float.parseFloat(strings[2]), Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Double.parseDouble(strings[5])));
                }
                bars.closeRead();
                sports.openRead("sports.txt");
                while ((string = sports.readLine()) != null) {
                    strings = string.split(",");
                    locationArrayList.add(new SportsArea(strings[0], Float.parseFloat(strings[1]), Float.parseFloat(strings[2]), new ArrayList<String>(Arrays.asList(strings[3].split(";")))));
                }
                sports.closeRead();
                exhibits.openRead("exhibits.txt");
                while ((string = exhibits.readLine()) != null) {
                    strings = string.split(",");
                    locationArrayList.add(new Exhibit(strings[0], Float.parseFloat(strings[1]), Float.parseFloat(strings[2]), Integer.parseInt(strings[3]), strings[4]));
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
    }

    /**
     * Gets locations.
     *
     * @return the locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Sets locations.
     *
     * @param locations the locations
     */
    private void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Login check.
     *
     * @param id the id of the person
     * @param pw the password
     * @return True if the password is correct
     */
    boolean loginCheck(int id, String pw) {
        for (Person person : getPeople()) {
            if (person.getId() == id) {
                if (person.getPassword() != null && person.getPassword().equals(pw))
                    return true;
                break;
            }
        }
        return false;
    }

    /**
     * Gets the list of people wwho are signed up in the event.
     *
     * @return the signed up
     */
    public ArrayList<Person> getSignedUp() {
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : getPeople()) {
            if (person.getPassword() != null) people.add(person);
        }
        return people;
    }

    /**
     * Gets the locations that aren't full.
     *
     * @return those locations
     */
    public ArrayList<Location> getFreeLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        for (Location location : getLocations()) {
            if (!signups.isFull(location)) locations.add(location);
        }
        return locations;
    }

    /**
     * Gets bars.
     *
     * @return the bars
     */
    public ArrayList<Bar> getBars() {
        ArrayList<Bar> bars = new ArrayList<>();
        for (Location location : locations) {
            if (location.type().equals("Bar")) {
                bars.add((Bar) location);
            }
        }
        return bars;
    }

    /**
     * Gets signup managing class.
     *
     * @return signups signups
     */
    public Signups getSignups() {
        return signups;
    }

    /**
     * Sets signups.
     *
     * @param signups the signups
     */
    private void setSignups(Signups signups) {
        this.signups = signups;
    }

    /**
     * Sort locations.
     *
     * @param list the list
     */
    void sortLocations(ArrayList<Location> list) {
        list.sort(new Comparator<Location>() {
            @Override
            public int compare(Location location, Location location1) {
                return signups.getNumSignups(location) - signups.getNumSignups(location1);
            }
        });
    }

    /**
     * Locations to strings array list.
     *
     * @param list the list
     * @return the array list
     */
    ArrayList<String> locationsToStrings(ArrayList<Location> list) {
        ArrayList<String> strings = new ArrayList<>();
        for (Location location : list)
            strings.add(location.toString() + ", " + getSignups().getNumSignups(location) + "/" + location.getCapacity());
        return strings;
    }

    /**
     * People to strings array list.
     *
     * @param list the list
     * @return the array list
     */
    ArrayList<String> peopleToStrings(ArrayList<Person> list) {
        ArrayList<String> strings = new ArrayList<>();
        for (Person person : list)
            strings.add(person.toString());
        return strings;
    }

    /**
     * Calculates the minimum revenue expected.
     *
     * @return the expected revenue
     */
    double minRevenue() {
        double revenue = 0;
        for (Location location : locations) {
            revenue += signups.getRevenue(location);
        }
        return revenue;
    }

    /**
     * Checks if a person is signed up to a location.
     *
     * @param person   the person
     * @param location the location
     * @return True or False
     */
    void signupLocation(Person person, Location location) {
        if (location.getCapacity() == 0 || signups.getNumSignups(location) < location.getCapacity())
            signups.addSignup(new Signup(person, location));
    }

    /**
     * Get person by id person.
     *
     * @param id the id
     * @return the person
     */
    Person getPersonByID(int id) {
        for (Person person : getPeople())
            if (person.getId() == id) return person;
        return null;
    }
}
