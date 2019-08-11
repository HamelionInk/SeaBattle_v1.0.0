package com.noile.sea_battle.logic.ships;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Boat extends Ships {

    private GamePanel game;
    private Cell enemyField[][];

    private ImageIcon textureShip;
    private ImageIcon textureShipCantPut;

    private int initX, initY;

    public Boat(int x, int y, GamePanel game) {

        textureShip = new ImageIcon("img/Ship/Boat.png");
        textureShipCantPut = new ImageIcon("img/Ship/BoatCantPut.png");

        setSize(1);
        setTextureShip(new ImageIcon("img/Ship/Boat.png"));

        setY(y);
        setX(x);
        setHeigth(25);
        setWidth(25);
        setShipPut(false);

        this.game = game;
        this.initX = x;
        this.initY = y;

    }

    public void mousePressed(MouseEvent e) {
        if(getShipPut() == false) {
            if ((e.getX() > getX() & e.getX() < getX() + 25) & (e.getY() > getY() & e.getY() < getY() + 25)) {
                setTest(true);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if( getTest() ) {
            setX(e.getX());
            setY(e.getY());
            if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 375 & e.getY() < 625)) {
                if ((getX() + getWidth() >= 100 & getX() + getWidth() <= 350) & (getY() + getHeigth() >= 400 & getY() + getHeigth() <= 650)) {
                    game.convertMouseCoord(e);
                    enemyField = game.getEnemyField();
                    setX(enemyField[game.getConvertMouseX()][game.getConvertMouseY()].getX());
                    setY(enemyField[game.getConvertMouseX()][game.getConvertMouseY()].getY());
                    setTextureShip(textureShip);
                }
            } else {
                setTextureShip(textureShipCantPut);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (getTest()) {
            if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 375 & e.getY() < 625)) {
                if ((getX() + getWidth() >= 100 & getX() + getWidth() <= 350) & (getY() + getHeigth() >= 400 & getY() + getHeigth() <= 650)) {
                    enemyField[game.getConvertMouseX()][game.getConvertMouseY()].test();
                    setShipPut(true);
                }
            } else {
                setX(initX);
                setY(initY);
                setTextureShip(textureShip);
            }
            setTest(false);
        }
    }
}
