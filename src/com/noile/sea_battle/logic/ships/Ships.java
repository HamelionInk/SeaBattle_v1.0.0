package com.noile.sea_battle.logic.ships;

import javax.swing.*;

public abstract class Ships {
    private int healPoints;
    private int size;
    private ImageIcon imageShip;

    public void takeDamage(){
            healPoints = healPoints - 1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    public ImageIcon getImageShip() {
        return imageShip;
    }

    public void setImageShip(ImageIcon imageShip) {
        this.imageShip = imageShip;
    }


}
