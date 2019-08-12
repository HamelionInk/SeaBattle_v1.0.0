package com.noile.sea_battle.logic.ships;

import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public abstract class Ships {
    private boolean test;
    private boolean shipPut;

    private int x,y;

    private int height;
    private int width;

    private ImageIcon textureShip;

    public boolean getShipPut() {
        return shipPut;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigth(int heigth) {
        this.height = heigth;
    }

    public void setShipPut(boolean shipPut) {
        this.shipPut = shipPut;
    }

    public int getHeigth() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public void setTextureShip(ImageIcon textureShip) {
        this.textureShip = textureShip;
    }

    public ImageIcon getTextureShip() {
        return textureShip;
    }

    public abstract void mouseDragged(MouseEvent e);

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);
}
