package com.noile.sea_battle.view;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Sea Battle");

        SwitchPanel aSwitchPanel = new SwitchPanel();
        GamePanel gamePanel = new GamePanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("img/frameIcon.jpg").getImage());
        setSize(1000,1000);
        setVisible(true);
        add(aSwitchPanel);
        //add(gamePanel);

        for (SwitchEnum value : SwitchEnum.values()) {
            aSwitchPanel.add(value.getPanel());
        }
    }
}
