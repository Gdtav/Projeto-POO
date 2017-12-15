package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChooseLocations {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private Mixer mixer;

    private void replaceComboBoxItems(JComboBox comboBox, ArrayList<String> strings){
        comboBox.removeAllItems();
        for (String string:strings)
            comboBox.addItem(string);
    }

    private ArrayList<Location> filterSelected(ArrayList<Location> locations, Location location){
        ArrayList<Location> list = new ArrayList<>(locations);
        list.remove(location);
        return list;
    }

    private ArrayList<String> locationsToStrings(ArrayList<Location> locations){
        ArrayList<String> strings = new ArrayList<>();
        mixer.sortLocations();
        for (Location location:locations)
            strings.add(location.getName() + ", " + Integer.toString(mixer.getSignups().getNumSignups(location)) + "/" + Integer.toString(location.getCapacity()) + ", " + Double.toString(location.getPrice()) + "€");
    }

    public ChooseLocations(Mixer mixer) {
        this.mixer = mixer;
        ArrayList<String> strings = new ArrayList<>();


        replaceComboBoxItems(comboBox1, locations);

        comboBox2.setEnabled(false);
        comboBox3.setEnabled(false);
        comboBox4.setEnabled(false);
        comboBox5.setEnabled(false);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(comboBox1.getSelectedIndex() == -1))

                    comboBox2.setEnabled(true);

            }
        });
    }
}
