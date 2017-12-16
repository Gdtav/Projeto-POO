package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class MainAdmin extends JFrame{
    private JButton newSignupButton;
    private JButton manageSignupsButton;
    private JButton guestListsButton;
    private JButton revenueButton;
    private JButton sairButton;
    private JLabel topLabel;
    private JPanel rootPanel;
    private JButton printLocationsButton;
    private JButton printPeopleButton;
    private NewSignup newSignup = null;

    public MainAdmin(Mixer mixer) {

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                exit(0);
            }
        });

        setContentPane(rootPanel);
        setSize(400, 300);
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
                new GuestLists(mixer, mixer.getBars());
            }
        });
        revenueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new printProfits(mixer, mixer.getSignups());
            }
        });
        printLocationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PrintLocations(mixer);
            }
        });
        printPeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PrintPeople(mixer);
            }
        });
    }
}
