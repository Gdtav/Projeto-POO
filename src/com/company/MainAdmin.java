package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.System.exit;

/**
 * The type Main admin.
 */
class MainAdmin extends JFrame {
    private JButton newSignupButton;
    private JButton manageSignupsButton;
    private JButton guestListsButton;
    private JButton revenueButton;
    private JButton exitButton;
    private JLabel topLabel;
    private JPanel rootPanel;
    private JButton printLocationsButton;
    private JButton printPeopleButton;
    private NewSignup newSignup = null;

    /**
     * Instantiates a new Main admin window.
     *
     * @param mixer the mixer
     */
    public MainAdmin(Mixer mixer) {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ObjectFile objectFile = new ObjectFile();
                try {
                    objectFile.openWrite("Mixer");
                    objectFile.writeObject(mixer);
                    objectFile.closeWrite();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Não foi possivel guardar os dados...");
                    exit(1);
                }
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
                if (newSignup == null || !newSignup.isShowing())
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
                new PrintProfits(mixer, mixer.getSignups());
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
