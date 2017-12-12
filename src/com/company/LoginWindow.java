package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    private JButton loginButton;
    private JTextField userField;
    private JTextField passwordField;
    private JLabel LoginLabel;


    public LoginWindow(String pw, Mixer mixer) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (userField.getText().equals("admin") && pw.equals(userField.getText())){

                }
                if(mixer.loginCheck(Integer.valueOf(userField.getText()),pw){

                }
            }
        });
    }
}
