package com.noile.Launcher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleField extends JButton {

    private int index;

    public BattleField(String imageRolloverPath, String imagePressedPath, String imageIconPath, int x, int y, int index) {
        this.index = index;
        System.out.println(index); // проверка присвоения индекса каждому объекту
        setOpaque(false);
        setContentAreaFilled(false);
        setRolloverIcon(new ImageIcon(imageRolloverPath));
        setPressedIcon(new ImageIcon(imagePressedPath));
        setIcon(new ImageIcon(imageIconPath));
        setBounds(x , y ,41,41);

        addActionListener(ActionEvent -> setIcon(new ImageIcon("img/just2.png")));

    }


}