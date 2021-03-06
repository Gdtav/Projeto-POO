package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Choose locations.
 */
class ChooseLocations extends JFrame {
    private JButton OKButton;
    private JPanel rootPanel;
    private JList locationList;
    private JLabel checkLabel;
    private Mixer mixer;

    /**
     * Instantiates a new Choose locations window.
     *
     * @param mixer  the mixer
     * @param person the person
     */
    public ChooseLocations(Mixer mixer, Person person) {
        this.mixer = mixer;
        ArrayList<Location> locations = mixer.getFreeLocations();
        ArrayList<Signup> selectedSignups = mixer.getSignups().getPersonSignups(person);

        for (Signup signup : selectedSignups)
            if (locations.indexOf(signup.getLocation()) == -1) locations.add(signup.getLocation());

        mixer.sortLocations(locations);
        int[] selectedIndices = new int[selectedSignups.size()];
        locationList.setListData(locationsToStrings(locations).toArray());
        for (int i = 0; i < selectedSignups.size(); i++)
            selectedIndices[i] = locations.indexOf(selectedSignups.get(i).getLocation());
        locationList.setSelectedIndices(selectedIndices);

        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mixer.getSignups().removePersonSignups(person);
                int[] indices = locationList.getSelectedIndices();
                if (indices.length > 5)
                    checkLabel.setText("Selecione no máximo 5 locais!");
                else {
                    for (int i = 0; i < selectedIndices.length; i++) {
                        if (!locationList.isSelectedIndex(selectedIndices[i]))
                            mixer.getSignups().removeSignup(selectedSignups.get(i));
                    }
                    boolean found;
                    for (int index : locationList.getSelectedIndices())
                        mixer.signupLocation(person, locations.get(index));
                    dispose();
                }
            }
        });
    }

    private ArrayList<String> locationsToStrings(ArrayList<Location> locations) {
        ArrayList<String> strings = new ArrayList<>();
        for (Location location : locations)
            strings.add(location.getName() + ", " + mixer.getSignups().getNumSignups(location) + "/" + location.getCapacity() + ", " + location.getPrice() + "€");
        return strings;
    }
}
