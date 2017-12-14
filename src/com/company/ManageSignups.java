package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageSignups extends JFrame{
    private JButton seguinteButton;
    private JButton voltarButton;
    private JList UserList;
    private JLabel titleLabel;
    private JLabel subtitleLabel;

    public ManageSignups() {
        voltarButton.addActionListener(new ActionListener() {
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
        seguinteButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                UserList.getSelectedIndex();
            }
        });

    }
}
