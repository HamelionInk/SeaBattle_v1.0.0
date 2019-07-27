package com.noile.SeaBattle.View;

import com.noile.SeaBattle.Logic.Ships.Boat;
import com.noile.SeaBattle.Logic.TakeShip;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShipsView extends JButton {

    public ShipsView(TakeShip takeShip) {
        super("TestShip");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                takeShip.setClassShip(new Boat());
                takeShip.setSize(3);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }
        });
    }
}
