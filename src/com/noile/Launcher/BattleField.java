package com.noile.Launcher;

import javax.swing.*;

public class BattleField extends JButton {

    public BattleField(String imageRolloverPath, String imagePressedPath, String imageIconPath, int x, int y) {

        setOpaque(false);
        setContentAreaFilled(false);
        setRolloverIcon(new ImageIcon(imageRolloverPath));
        setPressedIcon(new ImageIcon(imagePressedPath));
        setIcon(new ImageIcon(imageIconPath));

        setBounds(x , y ,41,41);

    }
}