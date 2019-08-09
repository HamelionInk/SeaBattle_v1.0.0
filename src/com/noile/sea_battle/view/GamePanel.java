package com.noile.sea_battle.view;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.ships.Cruiser;
import com.noile.sea_battle.logic.ships.Ships;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    ArrayList<ArrayList<Cell>> field;

    private ImageIcon background;

    private Ships cruiser;

    private int x,y;
    private int count;
    private int countAction;

    private Timer timer;

    public GamePanel() {
        background = new ImageIcon("img/GamePanelFont.jpg");
        timer = new Timer(20, this);

        x = 50;
        y = 50;
        count = -1;
        countAction = -1;

        timer.start();

        setLayout(null);

        createField();
        createShips();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < 10; i++) {
                    count++;
                    for (Cell cell : field.get(count)) {
                        cell.mouseClicked(e);
                    }
                }
                count = -1;
            }
        });
    }

    public void createField() {
        field = new ArrayList<>();
        for ( int i = 0; i < 10; i++) {
            field.add(new ArrayList<>());
        }

        for ( int i = 0; i < 10; i++) {
            count++;
            y += 25;
            x = 50;
            for ( int j = 0; j < 10; j++) {
                field.get(count).add(new Cell(x += 25 , y));
            }
        }
        count = -1;
    }

    public void createShips() {
        cruiser = new Cruiser();
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background.getImage(), 0,0, getWidth(), getHeight(), null);

        for (int i = 0; i < 10; i++) {
            countAction++;
            for (Cell cell : field.get(countAction)) {
                cell.render(g2d);
            }
        }
        countAction = -1;
        cruiser.render(g2d);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            countAction++;
            for (Cell cell : field.get(countAction)) {
                cell.state();
            }
        }
        countAction = -1;
        repaint();
    }

}

