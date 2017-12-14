package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuestLists extends JFrame{
    private JList barList;
    private JButton returnButton;
    private JButton printButton;
    private JLabel checkLabel;
    private JPanel rootPanel;

    public GuestLists(ArrayList<Bar> bars) {

        printButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!barList.isSelectionEmpty())
                    System.out.println(bars.get(barList.getSelectedIndex()));
                else checkLabel.setText("Escolha um bar!");
            }
        });
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

        barList.setListData(bars.toArray());

        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}