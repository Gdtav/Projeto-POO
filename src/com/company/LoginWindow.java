package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame{
    private JButton loginButton;
    private JTextField userField;
    private JTextField passwordField;
    private JLabel LoginLabel;
    private JPanel rootPanel;
    private JLabel checkLabel;
    private JButton sairButton;


    public LoginWindow(String pw, Mixer mixer) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (userField.getText().equals("admin") && pw.equals(userField.getText())){
                    System.out.println("admin login!");
                }
                else if(mixer.loginCheck(Integer.valueOf(userField.getText()),passwordField.getText())){
                    System.out.println("user #" + userField.getText() + " login!");
                }
                else{
                    checkLabel.setText("Login inválido!");
                }
            }
        });
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }
}
