package com.noile.sea_battle.view.button;

import com.noile.sea_battle.logic.PutShip;
import com.noile.sea_battle.logic.ships.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShipButton extends JButton {

    private PutShip test;
    private String name;

    public ShipButton(String name, PutShip test) {
        super(name);

        this.test = test;
        this.name = name;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                takeShip();
            }
        });
    }

    public void takeShip() {
        if(name.equals("Boat")) {
            test.setClassShips(new Boat());
        }
        if(name.equals("Submarine")) {
            test.setClassShips(new Submarine());
        }
        if(name.equals("Destroyer")) {
            test.setClassShips(new Destroyer());
        }
        if(name.equals("Cruiser")) {
            test.setClassShips(new Cruiser());
        }
    }
}
