package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class NewSignup extends JFrame {
    private JPanel rootPanel;
    private JList peopleList;
    private JTextField idTextField;
    private JButton selectListButton;
    private JButton exitButton;

    private void selectFromList() {

    }

    public NewSignup(Mixer mixer) {
        ArrayList<Person> people = mixer.getPeople();
        ArrayList<Person> notSignups = new ArrayList<>();
        ArrayList<String> choices = new ArrayList<>();
        for (Person person : people) {
            if (person.getPassword() == null)
                notSignups.add(person);
        }
        for (Person person : notSignups) {
            choices.add(person.getName() + ", " + person.getId());
        }
        peopleList.setListData(choices.toArray());

        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        peopleList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() >= 2) {
                    new passwordSelect("Selecione Password", notSignups.get(peopleList.getSelectedIndex()));
                    dispose();
                }
            }
        });
    }
}
