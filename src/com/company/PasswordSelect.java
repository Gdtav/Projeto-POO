package com.company;

import javax.swing.*;
import java.awt.event.*;

/**
 * The type Password select.
 */
class PasswordSelect extends JFrame {
    private JButton buttonOK;
    private JTextField passwordTextField;
    private JLabel checkLabel;
    private JPanel rootPanel;
    private Person person;


    /**
     * Instantiates a new Password select window.
     *
     * @param string the string
     * @param person the person
     */
    public PasswordSelect(String string, Person person) {
        super(string);
        this.person = person;
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        rootPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setContentPane(rootPanel);
        setSize(400, 150);
        setVisible(true);
    }

    private void onOK() {
        if (passwordTextField.getText().length() > 6) {
            person.setPassword(passwordTextField.getText());
            System.out.println(person.getPassword());
            dispose();
        } else
            checkLabel.setText("Insira uma Password válida!");
    }

    private void onCancel() {
        // add your code here if necessary

    }
}
