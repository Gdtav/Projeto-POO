package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Print profits.
 */
class PrintProfits extends JFrame {
    private JLabel titleLabel;
    private JButton OKButton;
    private JLabel valueLabel;
    private JPanel rootPanel;


    /**
     * Instantiates a new Print profits window.
     *
     * @param mixer   the mixer
     * @param signups the signups
     */
    public PrintProfits(Mixer mixer, Signups signups) {
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
