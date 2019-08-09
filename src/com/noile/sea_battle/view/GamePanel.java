package com.noile.sea_battle.view;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.ships.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    private ArrayList<ArrayList<Cell>> field;
    private ArrayList<Ships> cruiser;
    private ArrayList<Ships> boat;
    private ArrayList<Ships> submarine;
    private ArrayList<Ships> destroyer;


    private ImageIcon background;


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

            @Override
            public void mouseReleased(MouseEvent e) {
                for(Ships destroyer : destroyer) {
                    destroyer.mouseReleased(e);
                }
                for(Ships cruiser : cruiser) {
                    cruiser.mouseReleased(e);
                }
                for(Ships submarine : submarine) {
                    submarine.mouseReleased(e);
                }
                for(Ships boat : boat) {
                    boat.mouseReleased(e);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                for(Ships destroyer : destroyer) {
                    destroyer.mousePressed(e);
                }
                for(Ships cruiser : cruiser) {
                    cruiser.mousePressed(e);
                }
                for(Ships submarine : submarine) {
                    submarine.mousePressed(e);
                }
                for(Ships boat : boat) {
                    boat.mousePressed(e);
                }
            }

        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                for(Ships destroyer : destroyer) {
                    destroyer.mouseDragged(e);
                }
                for(Ships cruiser : cruiser) {
                    cruiser.mouseDragged(e);
                }
                for(Ships submarine : submarine) {
                    submarine.mouseDragged(e);
                }
                for(Ships boat : boat) {
                    boat.mouseDragged(e);
                }
                repaint();
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
        //Destroyer
        destroyer = new ArrayList<>();
        int destroyerPosX = 275;
        int destroyerPosY = 300;
        for( int i = 0; i < 1 ; i++) {
        destroyer.add(new Destroyer(destroyerPosX += 25, destroyerPosY));
        }
        //CruiserAdd
        cruiser = new ArrayList<>();
        int cruiserPosX = 275;
        int cruiserPosY = 400;
        for( int i = 0; i < 2 ; i++) {
            cruiser.add(new Cruiser(cruiserPosX += 25, cruiserPosY));
        }
        //SubmarineAdd
        submarine = new ArrayList<>();
        int submarinePosX = 275;
        int submarinePosY = 475;
        for( int i = 0; i < 3 ; i++) {
            submarine.add(new Submarine(submarinePosX += 25, submarinePosY));
        }
        //BoatAdd
        boat = new ArrayList<>();
        int boatPosX = 275;
        int boatPosY = 525;
        for( int i = 0; i < 4 ; i++) {
            boat.add(new Boat(boatPosX += 25, boatPosY));
        }

    }

    public void paintShips(Graphics2D g2d) {
        for(Ships destroyer : destroyer) {
            destroyer.render(g2d);
        }
        for(Ships cruiser : cruiser) {
            cruiser.render(g2d);
        }
        for(Ships submarine : submarine) {
            submarine.render(g2d);
        }
        for(Ships boat : boat) {
            boat.render(g2d);
        }
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
        paintShips(g2d);
        // cruiser.render(g2d);
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

