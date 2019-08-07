package com.noile.sea_battle.view;

import com.noile.sea_battle.logic.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel{

    private Cell cell;
    private ImageIcon test;

    public GamePanel() {
        test = new ImageIcon("img/GamePanelFont.jpg");
        cell = new Cell();
        setLayout(null);
    }

    public void update() {
        cell.update();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        update();
        g2d.drawImage(test.getImage(), 0,0, getWidth(), getHeight(), null);
        cell.render(g2d);
    }
}

