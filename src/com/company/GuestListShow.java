package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Guest list show.
 */
class GuestListShow extends JFrame {
    private JPanel rootPanel;
    private JList peopleList;
    private JButton OKButton;

    /**
     * Instantiates a new Guest list show window.
     *
     * @param mixer the mixer
     * @param bar   the bar
     */
    public GuestListShow(Mixer mixer, Bar bar) {
        ArrayList<Person> people = mixer.getSignups().guestList(bar);
        ArrayList<String> strings = mixer.peopleToStrings(people);
        peopleList.setListData(strings.toArray());
        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }
}
