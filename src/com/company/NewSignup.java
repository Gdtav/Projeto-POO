package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * The type New signup.
 */
class NewSignup extends JFrame {
    private JPanel rootPanel;
    private JList peopleList;
    private JTextField idTextField;
    private JButton selectListButton;
    private JButton exitButton;
    private JLabel checkLabel;

    /**
     * Instantiates a new New signup.
     *
     * @param mixer the mixer
     */
    public NewSignup(Mixer mixer) {
        ArrayList<Person> people = mixer.getPeople();
        ArrayList<Person> notSignups = new ArrayList<>();
        ArrayList<String> choices = new ArrayList<>();
        for (Person person : people) {
            if (person.getPassword() == null)
                notSignups.add(person);
        }
        for (Person person : notSignups) {
            choices.add(person.getName() + ", " + person.getId());
        }
        peopleList.setListData(choices.toArray());

        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        peopleList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() >= 2) {
                    new PasswordSelect("Selecione Password", notSignups.get(peopleList.getSelectedIndex()));
                    dispose();
                }
            }
        });
        selectListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Person person;
                    if ((person = mixer.getPersonByID(Integer.valueOf(idTextField.getText()))) != null) {
                        new PasswordSelect("Selecione Password", person);
                        dispose();
                    } else
                        checkLabel.setText("ID desconhecido!");
                } catch (NumberFormatException nExc) {
                    checkLabel.setText("Insira um ID válido!");
                }
            }
        });
    }
}
