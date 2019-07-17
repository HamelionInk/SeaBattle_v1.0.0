package com.noile.Launcher;

import javax.swing.*;

public class RecordsPanel extends JPanel {

    JButton test2 = new JButton("test");

    public void getButtonGP() {
        test2.setBorder(null);
        test2.setBorderPainted(false);
        test2.setOpaque(false);
        test2.setContentAreaFilled(false);
        test2.setRolloverIcon(new ImageIcon("img/Button/ButtonExitRollover.png"));
        test2.setPressedIcon(new ImageIcon("img/Button/ButtonExitPressed.png"));
        test2.setIcon(new ImageIcon("img/Button/ButtonExit.png"));
        test2.addActionListener(actionEvent -> {
            GamePanelEnum.BACKGROUND.show();
        });
    }

    public RecordsPanel() {
        getButtonGP();
        add(test2);
    }
}

