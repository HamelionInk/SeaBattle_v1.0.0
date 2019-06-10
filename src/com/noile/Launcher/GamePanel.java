package com.noile.Launcher;

import javax.swing.*;

public class GamePanel extends JPanel {

    JButton test1 = new JButton("test");


    public void getButtonGP() {
        test1.setBorder(null);
        test1.setBorderPainted(false);
        test1.setOpaque(false);
        test1.setContentAreaFilled(false);
        test1.setRolloverIcon(new ImageIcon("img/Button/ButtonExitRollover.png"));
        test1.setPressedIcon(new ImageIcon("img/Button/ButtonExitPressed.png"));
        test1.setIcon(new ImageIcon("img/Button/ButtonExit.png"));
        test1.addActionListener(actionEvent -> {
            GamePanelEnum.BACKGROUND.show();
        });
    }

    public GamePanel() {
        getButtonGP();
        add(test1);
    }
}
