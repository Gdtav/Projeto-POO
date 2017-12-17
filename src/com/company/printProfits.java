package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class printProfits extends JFrame{
    private JLabel titleLabel;
    private JButton OKButton;
    private JLabel valueLabel;
    private JPanel rootPanel;


    public printProfits(Mixer mixer, Signups signups) {
        setContentPane(rootPanel);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        valueLabel.setText(Double.toString(mixer.minRevenue()));
        OKButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
