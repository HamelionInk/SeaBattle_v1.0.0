package com.noile.sea_battle.logic.ships;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Cruiser extends Ships {

    private int x,y;

    public Cruiser() {
        setSize(3);
        setTextureShip(new ImageIcon("img/Ship/Cruiser.png"));

        x = 50;
        y = 50;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawImage(getImageShip().getImage(), getX(),getY(),null);
    }

    public void mousePressed(MouseEvent e) {
        if ( (e.getX() > getX() & e.getX() < getX() + 25) & (e.getY() > getY() & e.getY() < getY() + 75 )) {
            setTest(true);
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if( getTest() ) {
            x = e.getX();
            y = e.getY();
        }
    }
}
