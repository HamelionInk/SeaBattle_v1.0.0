package com.noile.sea_battle.logic;

import com.noile.sea_battle.logic.ships.Ships;

import javax.swing.*;

public class Cell {

    Ships classShip;

    private String shipLink = "img/Ship/Ship.png";

    ImageIcon shipImage;

    public Cell() {
    }

    public void state() {
        if (classShip != null) {
            shipImage = new ImageIcon(shipLink);
        }
    }

    public void setClassShip(Ships classShip) {
        this.classShip = classShip;
    }

    public Ships getClassShip() {
        return classShip;
    }

    public ImageIcon getShipImage() {
        return shipImage;
    }
}
