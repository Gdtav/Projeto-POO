package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintLocations extends JFrame{
    private JPanel rootPanel;
    private JList locationList;
    private JButton OKButton;
    private JTextArea infoTextArea;


    public PrintLocations(Mixer mixer) {
        infoTextArea.setEditable(false);
        mixer.sortLocations(mixer.getLocations());
        locationList.setListData(mixer.locationsToStrings(mixer.getLocations()).toArray());
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        locationList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                infoTextArea.setText(mixer.getLocations().get(locationList.getSelectedIndex()).attributes());
            }
        });
    }
}
