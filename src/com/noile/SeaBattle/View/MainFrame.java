package com.noile.SeaBattle.View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Sea Battle");

        SwitchPanel aSwitchPanel = new SwitchPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("img/frameIcon.jpg").getImage());
        setSize(1000,1000);
        setVisible(true);
        add(aSwitchPanel);

        for (SwitchEnum value : SwitchEnum.values()) {
            aSwitchPanel.add(value.getPanel());
        }
    }
}
