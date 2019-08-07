package com.noile.sea_battle.logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Cell extends KeyAdapter {
    private ImageIcon texture;

    private int x, y;

    public Cell() {
        texture = new ImageIcon("img/Cell/Sea.png");

        x = 100;
        y = 100;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update() {
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(texture.getImage(), getX(), getY(),null);
    }
}





