package com.noile.sea_battle.logic.ships;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.cell.EnumCheckBlock;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Boat extends Ships {

    private GamePanel gamePanel;
    private Cell field[][];

    private ImageIcon textureShip;
    private ImageIcon textureShipCantPut;

    private boolean check;


    private int initX, initY;

    public Boat(int x, int y, GamePanel gamePanel) {

        textureShip = new ImageIcon("img/Ship/Boat.png");
        textureShipCantPut = new ImageIcon("img/Ship/BoatCantPut.png");

        setTextureShip(new ImageIcon("img/Ship/Boat.png"));

        setY(y);
        setX(x);
        setHeigth(25);
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
            gamePanel.getGame().convertMouseCordField(e);
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
                        System.out.println("1");
                    }
                } else {
                    setTextureShip(textureShipCantPut);
                    System.out.println("2");

                }
            } else {
                setTextureShip(textureShipCantPut);
                System.out.println("3");

            }
        }
        check = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (getTest()) {
            if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                if ((getX() + getWidth() >= 100 & getX() + getWidth() <= 350) & (getY() + getHeigth() >= 100 & getY() + getHeigth() <= 350)) {
                    check();
                    if (check) {
                        field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].checkShip();
                        for (int i = gamePanel.getGame().getConvertMouseX() - 1; i < gamePanel.getGame().getConvertMouseX() + 2; i++) {
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
        for(int i = gamePanel.getGame().getConvertMouseX(); i < gamePanel.getGame().getConvertMouseX() + 1; i++) {
            for(int j = gamePanel.getGame().getConvertMouseY(); j < gamePanel.getGame().getConvertMouseY() + 1; j++) {
                if((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                    if(field[i][j].getEnumCheckBlock() == EnumCheckBlock.BLOCKED) {
                        check = false;
                    }
                }
            }
        }
    }
}
