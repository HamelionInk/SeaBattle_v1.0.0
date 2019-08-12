package com.noile.sea_battle.logic.ships;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Submarine extends Ships{

    private GamePanel gamePanel;
    private Cell field[][];

    private ImageIcon textureShip;
    private ImageIcon textureShipCantPut;

    private int initX, initY;

    public Submarine(int x, int y, GamePanel gamePanel) {

        textureShip = new ImageIcon("img/Ship/Submarine.png");
        textureShipCantPut = new ImageIcon("img/Ship/SubmarineCantPut.png");

        setTextureShip(textureShip);

        setY(y);
        setX(x);
        setHeigth(50);
        setWidth(25);
        setShipPut(false);

        this.gamePanel = gamePanel;
        this.initX = x;
        this.initY = y;

    }

    public void mousePressed(MouseEvent e) {
        if(getShipPut() == false) {
            if ((e.getX() > getX() & e.getX() < getX() + getWidth()) & (e.getY() > getY() & e.getY() < getY() + getHeigth())) {
                setTest(true);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if( getTest() ) {
            setX(e.getX());
            setY(e.getY());
            if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                if ((getX() + getWidth() >= 100 & getX() + getWidth() <= 350) & (getY() + getHeigth() >= 100 & getY() + getHeigth() <= 350)) {
                    gamePanel.getGame().convertMouseCordField(e);
                    field = gamePanel.getField();
                    setX(field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].getX());
                    setY(field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].getY());
                    setTextureShip(textureShip);
                }
            } else {
                setTextureShip(textureShipCantPut);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(getTest()) {
            if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                if ((getX() + getWidth() >= 100 & getX() + getWidth() <= 350) & (getY() + getHeigth() >= 100 & getY() + getHeigth() <= 350)) {
                    field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].checkShip();
                    field[gamePanel.getGame().getConvertMouseX() + 1][gamePanel.getGame().getConvertMouseY()].checkShip();
                    setShipPut(true);
                }
            }
            else {
                setX(initX);
                setY(initY);
                setTextureShip(textureShip);
            }
        }
        setTest(false);
    }
}
