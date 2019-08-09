package com.noile.sea_battle.logic.ships;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Ships {
    private int size;
    private ImageIcon textureShip;
    private boolean test;

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

    public ImageIcon getImageShip() {
        return textureShip;
    }

    public abstract void render(Graphics2D g2d);

    public abstract void mouseDragged(MouseEvent e);

    public abstract void mousePressed(MouseEvent e);
}
