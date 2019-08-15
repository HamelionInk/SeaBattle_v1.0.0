package com.noile.sea_battle.view;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.game_process.Game;
import com.noile.sea_battle.logic.ships.*;
import com.noile.sea_battle.view.button.AxisButton;
import com.noile.sea_battle.view.button.StageButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    private Cell[][] field;
    private Cell[][] enemyField;
    private ArrayList<Ships> destroyer;
    private ArrayList<Ships> cruiser;
    private ArrayList<Ships> submarine;
    private ArrayList<Ships> boat;

    private ImageIcon background;

    private StageButton stageButton;
    private AxisButton axisButton;

    private Game game;

    private int enemyX,enemyY;
    private int myX, myY;

    private Timer timer;

    public GamePanel() {
        background = new ImageIcon("img/Font.jpg");
        timer = new Timer(20, this);
        game = new Game();

        enemyX = 50;
        enemyY = 350;
        myX = 50;
        myY = 50;

        timer.start();

        setLayout(null);

        createField();
        createEnemyField();
        createShips();
        createButton();



        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            { if((e.getX() > 75 & e.getX() < 325) & (e.getY() > 375 & e.getY() < 625)) {
                game.convertMouseCordEnemyField(e);
                enemyField[game.getConvertMouseX()][game.getConvertMouseY()].mouseClicked();
            }
            if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                game.convertMouseCordField(e);
                field[game.getConvertMouseX()][game.getConvertMouseY()].mouseClicked();
            }
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
            }
        });
    }

    public Game getGame() {
        return game;
    }

    public Cell[][] getEnemyField() {
        return enemyField;
    }

    public Cell[][] getField() {
        return field;
    }

    public void createButton() {
        stageButton = new StageButton(game);
        axisButton = new AxisButton(game);
        stageButton.setBounds(700,700, 100,25);
        axisButton.setBounds(700,725,100,25);
        add(stageButton);
        add(axisButton);
    }

    public void createEnemyField() {
        enemyField = new Cell[10][10];

        for ( int x = 0; x < 10; x++) {
            enemyY += 25;
            enemyX = 50;
            for ( int y = 0; y < 10; y++) {
                enemyField[x][y] = new Cell(enemyX += 25, enemyY, game);
            }
        }
    }

    public void paintEnemyField(Graphics2D g2d) {
        for ( int x = 0; x < 10; x++) {
            for ( int y = 0; y < 10; y++) {
                g2d.drawImage(enemyField[x][y].getTexture().getImage(), enemyField[x][y].getX(), enemyField[x][y].getY(), null);
            }
        }
    }

    public void createField() {
        field = new Cell[10][10];

        for ( int x = 0; x < 10; x++) {
            myY += 25;
            myX = 50;
            for ( int y = 0; y < 10; y++) {
                field[x][y] = new Cell(myX += 25, myY, game);
            }
        }
    }

    public void paintField(Graphics2D g2d) {
        for ( int x = 0; x < 10; x++) {
            for ( int y = 0; y < 10; y++) {
                g2d.drawImage(field[x][y].getTexture().getImage(), field[x][y].getX(), field[x][y].getY(), null);
            }
        }
    }

    public void createShips() {
        //DestroyerAdd
        destroyer = new ArrayList<>();
        int destroyerPosX = 500;
        int destroyerPosY = 300;
        for( int i = 0; i < 1 ; i++) {
        destroyer.add(new Destroyer(destroyerPosX += 25, destroyerPosY, this));
        }
        //CruiserAdd
        cruiser = new ArrayList<>();
        int cruiserPosX = 500;
        int cruiserPosY = 400;
        for( int i = 0; i < 2 ; i++) {
            cruiser.add(new Cruiser(cruiserPosX += 25, cruiserPosY, this));
        }
        //SubmarineAdd
        submarine = new ArrayList<>();
        int submarinePosX = 500;
        int submarinePosY = 475;
        for( int i = 0; i < 3 ; i++) {
            submarine.add(new Submarine(submarinePosX += 25, submarinePosY, this));
        }
        //BoatAdd
        boat = new ArrayList<>();
        int boatPosX = 500;
        int boatPosY = 525;
        for( int i = 0; i < 4 ; i++) {
            boat.add(new Boat(boatPosX += 25, boatPosY, this));
        }

    }

    public void paintShips(Graphics2D g2d) {
        for (Ships destroyer : destroyer) {
            g2d.drawImage(destroyer.getTextureShip().getImage(), destroyer.getX(),destroyer.getY(),null);
        }
        for (Ships cruiser : cruiser) {
            g2d.drawImage(cruiser.getTextureShip().getImage(), cruiser.getX(),cruiser.getY(),null);
        }
        for (Ships submarine : submarine) {
            g2d.drawImage(submarine.getTextureShip().getImage(), submarine.getX(),submarine.getY(),null);
        }
        for (Ships boat : boat) {
            g2d.drawImage(boat.getTextureShip().getImage(), boat.getX(),boat.getY(),null);
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background.getImage(), 0,0, getWidth(), getHeight(), null);
        paintEnemyField(g2d);
        paintField(g2d);
        paintShips(g2d);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}

