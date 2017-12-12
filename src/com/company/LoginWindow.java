package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginWindow {
    JPanel panel1;
    private JButton button1;
    private JList list1;
    private Integer[] ints = {1, 2, 3, 4};

    public LoginWindow(ArrayList<Person> people) {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < people.size(); i++) {
            listModel.add(i, people.get(i).getName());
        }
        list1.setListData(listModel.toArray());

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = list1.getSelectedIndex();
                System.out.println(people.get(index).getName());
            }
        });
    }
}
