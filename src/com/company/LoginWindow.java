package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Login window.
 */
class LoginWindow extends JFrame {
    private JButton loginButton;
    private JTextField userField;
    private JTextField passwordField;
    private JLabel LoginLabel;
    private JPanel rootPanel;
    private JLabel checkLabel;
    private JButton sairButton;
    private String pw;
    private Mixer mixer;

    /**
     * Instantiates a new Login window.
     *
     * @param pw    the pw
     * @param mixer the mixer
     */
    public LoginWindow(String pw, Mixer mixer) {

        this.pw = pw;
        this.mixer = mixer;

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loginAction();
            }
        });

        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loginAction();
            }
        });

        userField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loginAction();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        //System.out.println("hello");
        setContentPane(rootPanel);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loginAction() {
        try {
            if (userField.getText().equals("admin") && pw.equals(passwordField.getText())) {
                System.out.println("admin login!");
                new MainAdmin(mixer);
                dispose();
            } else if (mixer.loginCheck(Integer.valueOf(userField.getText()), passwordField.getText())) {
                new MainUser(mixer, mixer.getPersonByID(Integer.valueOf(userField.getText())));
                dispose();
            } else {
                checkLabel.setText("Combinação id/password desconhecida!");
            }
        } catch (NumberFormatException nExc) {
            checkLabel.setText("Id inválido!");
        }
    }
}
