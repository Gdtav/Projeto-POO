package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Print locations.
 */
class PrintLocations extends JFrame {
    private JPanel rootPanel;
    private JList locationList;
    private JButton OKButton;
    private JTextArea infoTextArea;
    private JButton invertButton;
    private boolean invert = false;

    private void setData(Mixer mixer) {
        if (invert) {
            mixer.sortLocations(mixer.getLocations());
            invert = false;
        } else {
            mixer.sortLocationsInverted(mixer.getLocations());
            invert = true;
        }
        locationList.setListData(mixer.locationsToStrings(mixer.getLocations()).toArray());
        infoTextArea.setText("");
    }


    /**
     * Instantiates a new Print locations.
     *
     * @param mixer the mixer
     */
    public PrintLocations(Mixer mixer) {
        locationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        infoTextArea.setEditable(false);
        setData(mixer);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        locationList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                infoTextArea.setText(mixer.getLocations().get(locationList.getSelectedIndex()).attributes());
            }
        });
        invertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setData(mixer);
            }
        });
    }
}
