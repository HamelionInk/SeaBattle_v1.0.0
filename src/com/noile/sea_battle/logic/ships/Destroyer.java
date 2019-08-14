package com.noile.sea_battle.logic.ships;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.cell.EnumCheckBlock;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Destroyer extends Ships {

    private GamePanel gamePanel;
    private Cell field[][];

    private ImageIcon textureShip;
    private ImageIcon textureShipCantPut;

    private int initX, initY;

    private boolean check;

    public Destroyer(int x, int y, GamePanel gamePanel) {

        textureShip = new ImageIcon("img/Ship/Destroyer.png");
        textureShipCantPut = new ImageIcon("img/Ship/DestroyerCantPut.png");

        setTextureShip(textureShip);

        setY(y);
        setX(x);
        setHeigth(100);
        setWidth(25);
        setShipPut(false);

        this.gamePanel = gamePanel;
        this.initX = x;
        this.initY = y;

        check = true;
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
                    check();
                    if(check) {
                        setX(field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].getX());
                        setY(field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].getY());
                        setTextureShip(textureShip);
                    } else {
                        setTextureShip(textureShipCantPut);
                    }
                } else {
                    setTextureShip(textureShipCantPut);
                }
            } else {
                setTextureShip(textureShipCantPut);
            }
        }
        check = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (getTest()) {
            if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                if ((getX() + getWidth() >= 75 & getX() + getWidth() <= 325) & (getY() + getHeigth() >= 75 & getY() + getHeigth() <= 325)) {
                    check();
                    if (check) {
                        field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].checkShip();
                        field[gamePanel.getGame().getConvertMouseX() + 1][gamePanel.getGame().getConvertMouseY()].checkShip();
                        field[gamePanel.getGame().getConvertMouseX() + 2][gamePanel.getGame().getConvertMouseY()].checkShip();
                        field[gamePanel.getGame().getConvertMouseX() + 3][gamePanel.getGame().getConvertMouseY()].checkShip();
                        System.out.println("work");
                        for (int i = gamePanel.getGame().getConvertMouseX() - 1; i < gamePanel.getGame().getConvertMouseX() + 5; i++) {
                            for (int j = gamePanel.getGame().getConvertMouseY() - 1; j < gamePanel.getGame().getConvertMouseY() + 2; j++) {
                                if ((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                                    field[i][j].checkBlock();
                                }
                            }
                        }
                        setShipPut(true);
                    } else {
                        setX(initX);
                        setY(initY);
                        setTextureShip(textureShip);
                    }
                } else {
                    setX(initX);
                    setY(initY);
                    setTextureShip(textureShip);
                }
            } else {
                setX(initX);
                setY(initY);
                setTextureShip(textureShip);
            }
        }
        setTest(false);
    }

    public void check() {
        for(int i = gamePanel.getGame().getConvertMouseX(); i < gamePanel.getGame().getConvertMouseX() + 4; i++) {
            for(int j = gamePanel.getGame().getConvertMouseY(); j < gamePanel.getGame().getConvertMouseY() + 2; j++) {
                if((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                    if(field[i][j].getEnumCheckBlock() == EnumCheckBlock.BLOCKED) {
                        check = false;
                    }
                }
            }
        }
    }
}
