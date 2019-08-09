package com.noile.sea_battle.logic.ships;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Cruiser extends Ships {

    public Cruiser(int x, int y) {
        setSize(3);
        setTextureShip(new ImageIcon("img/Ship/Cruiser.png"));

       setY(y);
       setX(x);
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
            setX(e.getX());
            setY(e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setTest(false);
    }
}
