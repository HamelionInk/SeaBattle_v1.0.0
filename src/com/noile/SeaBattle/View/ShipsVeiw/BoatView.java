package com.noile.SeaBattle.View.ShipsVeiw;

import com.noile.SeaBattle.Logic.Ships.Boat;
import com.noile.SeaBattle.Logic.TakeShip;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoatView extends JButton {

    public BoatView(TakeShip takeShip) {
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
