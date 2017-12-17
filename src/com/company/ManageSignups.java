package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Manage signups.
 */
class ManageSignups extends JFrame {
    private JButton nextButton;
    private JButton returnButton;
    private JList UserList;
    private JLabel subtitleLabel;
    private JPanel rootPanel;

    /**
     * Instantiates a new Manage signups.
     *
     * @param mixer the mixer
     */
    public ManageSignups(Mixer mixer) {
        ArrayList<Person> people = mixer.getSignedUp();
        ArrayList<String> choices = new ArrayList<>();
        for (Person person : people) {
            choices.add(person.getName() + ", " + person.getId());
        }
        UserList.setListData(choices.toArray());

        returnButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseLocations(mixer, people.get(UserList.getSelectedIndex()));
            }
        });

        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}
