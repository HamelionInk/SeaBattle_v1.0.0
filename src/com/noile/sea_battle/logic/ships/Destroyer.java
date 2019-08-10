package com.noile.sea_battle.logic.ships;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Destroyer extends Ships {

    private GamePanel game;
    private Cell enemyField[][];

    public Destroyer(int x, int y, GamePanel game) {
        setSize(4);
        setTextureShip(new ImageIcon("img/Ship/Destroyer.png"));

        setY(y);
        setX(x);
        setHeigth(100);
        setWidth(25);
        setShipPut(false);

        this.game = game;
    }

    public void mousePressed(MouseEvent e) {
        if(getShipPut() == false) {
            if ((e.getX() > getX() & e.getX() < getX() + 25) & (e.getY() > getY() & e.getY() < getY() + 100)) {
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
                if ((getX() + getWidth() > 100 & getX() + getWidth() < 400) & (getY() + getHeigth() > 400 & getY() + getHeigth() < 650)) {
                    game.convertMouseCoord(e);
                    enemyField = game.getEnemyField();
                    setX(enemyField[game.getConvertMouseX()][game.getConvertMouseY()].getX());
                    setY(enemyField[game.getConvertMouseX()][game.getConvertMouseY()].getY());
                }
            }
        }


        }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(getTest()) {
            if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 375 & e.getY() < 625)) {
                if ((getX() + getWidth() >= 100 & getX() + getWidth() <= 400) & (getY() + getHeigth() >= 400 & getY() + getHeigth() <= 650)) {
                    enemyField[game.getConvertMouseX()][game.getConvertMouseY()].test();
                    enemyField[game.getConvertMouseX() + 1][game.getConvertMouseY()].test();
                    enemyField[game.getConvertMouseX() + 2][game.getConvertMouseY()].test();
                    enemyField[game.getConvertMouseX() + 3][game.getConvertMouseY()].test();
                    setShipPut(true);
                }
            }
        }
        setTest(false);
    }
}
