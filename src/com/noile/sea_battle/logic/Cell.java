package com.noile.sea_battle.logic;

import com.noile.sea_battle.logic.ships.Ships;

import javax.swing.*;
import java.awt.*;

public class Cell {

    Ships classShip;

    private String shipLink = "img/Ship/Ship1.png";
    private Color color;

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

    public void setColorRed() {
        color = Color.RED;
    }

    public void setColorGreen() {
        color = Color.GREEN;
    }

    public Color getColor() {
        return color;
    }
}
