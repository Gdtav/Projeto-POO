package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintPeople extends JFrame{
    private JPanel rootPanel;
    private JTextArea infoTextArea;
    private JButton OKButton;
    private JList peopleList;

    public PrintPeople(Mixer mixer) {
        infoTextArea.setEditable(false);
        peopleList.setListData(mixer.peopleToStrings(mixer.getPeople()).toArray());
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
        peopleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                infoTextArea.setText(mixer.getPeople().get(peopleList.getSelectedIndex()).attributes());
            }
        });
    }
}
