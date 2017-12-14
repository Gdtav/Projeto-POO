package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JButton loginButton;
    private JTextField userField;
    private JTextField passwordField;
    private JLabel LoginLabel;
    private JPanel rootPanel;
    private JLabel checkLabel;
    private JButton sairButton;
    private String pw;
    private Mixer mixer;

    void loginAction() {
        try {
            if (userField.getText().equals("admin") && pw.equals(passwordField.getText())) {
                System.out.println("admin login!");
                new MainAdmin(mixer);
                System.out.println("lmao");
            } else if (mixer.loginCheck(Integer.valueOf(userField.getText()), passwordField.getText())) {
                System.out.println("user #" + userField.getText() + " login!");
            } else {
                checkLabel.setText("Combinação id/password desconhecida!");
            }
        } catch (NumberFormatException nExc) {
            checkLabel.setText("Id inválido!");
        }
    }

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
}
