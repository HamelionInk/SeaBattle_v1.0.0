package com.noile.sea_battle.logic.ships;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Ships {
    private int size;
    private boolean test;

    private int x,y;

    private ImageIcon textureShip;

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
