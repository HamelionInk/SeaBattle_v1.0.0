package com.noile.sea_battle.view.button;

import com.noile.sea_battle.logic.PutShip;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AxisButton extends JButton {

    public AxisButton(String name, PutShip putShip) {
        super(name);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (putShip.getAxis() == 0) {
                    putShip.setAxis(1);
                    setText("Axis Y");
                    System.out.println(putShip.getAxis());
                    repaint();
                } else {
                    if (putShip.getAxis() == 1) {
                        putShip.setAxis(0);
                        setText("Axis X");
                        System.out.println(putShip.getAxis());
                        repaint();
                    }
                }
            }
        });
    }
}
