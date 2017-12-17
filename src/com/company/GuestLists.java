package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Guest lists.
 */
class GuestLists extends JFrame {
    private JList barList;
    private JButton returnButton;
    private JButton printButton;
    private JLabel checkLabel;
    private JPanel rootPanel;
    private JLabel titleLabel;

    /**
     * Instantiates a new Guest lists.
     *
     * @param mixer the mixer
     * @param bars  the bars
     */
    public GuestLists(Mixer mixer, ArrayList<Bar> bars) {

        printButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!barList.isSelectionEmpty())
                    new GuestListShow(mixer, bars.get(barList.getSelectedIndex()));
                else checkLabel.setText("Escolha um bar!");
            }
        });
        returnButton.addActionListener(new ActionListener() {
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

        barList.setListData(bars.toArray());

        setContentPane(rootPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
