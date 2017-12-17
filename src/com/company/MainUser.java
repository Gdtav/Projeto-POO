package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.System.exit;

/**
 * The type Main user.
 */
class MainUser extends JFrame {
    private JPanel rootPanel;
    private JButton chooseLocationsButton;
    private JButton printLocationsButton;
    private JButton exitButton;

    /**
     * Instantiates a new Main user.
     *
     * @param mixer  the mixer
     * @param person the person
     */
    public MainUser(Mixer mixer, Person person) {
        chooseLocationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ChooseLocations(mixer, person);
            }
        });
        printLocationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PrintLocations(mixer);
            }
        });
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
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
