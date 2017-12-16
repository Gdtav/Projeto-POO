package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class printProfits extends JFrame{
    private JLabel titleLabel;
    private JButton OKButton;
    private JLabel valueLabel;


    public double getTotalRevenue(Mixer mixer, Signups signups){
        double tRevenue = 0;
        for (Location local: mixer.getLocations()) {
            tRevenue += signups.getRevenue(local);
        }
        return tRevenue;
    }

    public printProfits(Mixer mixer) {
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
