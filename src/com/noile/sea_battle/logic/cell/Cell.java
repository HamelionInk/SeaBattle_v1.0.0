package com.noile.sea_battle.logic.cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Cell{
    private ImageIcon texture;
    private ImageIcon textureHit;

    private EnumCell enumCell;

    private int x, y;

    public Cell(int x, int y) {

        texture = new ImageIcon("img/Cell/Sea.png");
        textureHit = new ImageIcon("img/Cell/Hit.png");

        enumCell = EnumCell.INITIAL;

        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void state() {
        switch (enumCell) {
            case HIT:
                texture = textureHit;
                break;
            case MISS:
                break;
        }
    }

    public void mouseClicked(MouseEvent e) {
        if((e.getX() > getX() & e.getX() < getX() + 25) & (e.getY() > getY() & e.getY() < getY() + 25 )) {
            enumCell = EnumCell.HIT;
        }
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(texture.getImage(), getX(), getY(),null);
    }
}





