package com.noile.sea_battle.view.button;

import javax.swing.*;

public class MenuButton extends JButton {

    public MenuButton(String imageRolloverPath, String imagePressedPath, String imageIconPath) {

        setBorder(null);
        setBorderPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setRolloverIcon(new ImageIcon(imageRolloverPath));
        setPressedIcon(new ImageIcon(imagePressedPath));
        setIcon(new ImageIcon(imageIconPath));
    }
}
