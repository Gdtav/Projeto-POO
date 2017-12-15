package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAdmin extends JFrame{
    private JButton newSignupButton;
    private JButton manageSignupsButton;
    private JButton guestListsButton;
    private JButton revenueButton;
    private JButton sairButton;
    private JLabel topLabel;
    private JPanel rootPanel;
    private NewSignup newSignup = null;

    public MainAdmin(Mixer mixer) {

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        setContentPane(rootPanel);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        newSignupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(newSignup == null || !newSignup.isShowing())
                    newSignup = new NewSignup(mixer);
            }
        });
        manageSignupsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ManageSignups(mixer);
            }
        });
        guestListsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new GuestLists(mixer.getBars());
            }
        });
        revenueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
