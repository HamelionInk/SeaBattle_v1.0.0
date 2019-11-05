package com.noile.sea_battle.logic.ships;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.cell.EnumCheckBlock;
import com.noile.sea_battle.logic.game_process.EnumAxis;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Submarine extends Ships {

    private GamePanel gamePanel;
    private Cell field[][];
    private Cell enemyField[][];

    private ImageIcon textureShipX;
    private ImageIcon textureShipY;
    private ImageIcon textureShipCantPutX;
    private ImageIcon textureShipCantPutY;

    private boolean check;

    private int axis;
    private int initX, initY;

    public Submarine(int x, int y, GamePanel gamePanel) {

        textureShipX = new ImageIcon("img/Ship/SubmarineX.png");
        textureShipY = new ImageIcon("img/Ship/SubmarineY.png");
        textureShipCantPutX = new ImageIcon("img/Ship/SubmarineCantPutX.png");
        textureShipCantPutY = new ImageIcon("img/Ship/SubmarineCantPutY.png");

        setTextureShip(textureShipX);

        setHp(2);
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
    public void viewDestroyShip() {
        if (axis == 0) {
            for (int i = getX() - 1; i < getX() + 3; i++) {
                for (int j = getY() - 1; j < getY() + 2; j++) {
                    if ((i < enemyField.length & i >= 0) & (j < enemyField.length & j >= 0)) {
                        enemyField[i][j].destroyShipArea();
                        enemyField[getX()][getY()].destroyShip();
                        enemyField[getX() + 1][getY()].destroyShip();
                    }
                }
            }
        }

        if (axis == 1) {
            for (int i = getX() - 1; i < getX() + 2; i++) {
                for (int j = getY() - 1; j < getY() + 3; j++) {
                    if ((i < enemyField.length & i >= 0) & (j < enemyField.length & j >= 0)) {
                        enemyField[i][j].destroyShipArea();
                        enemyField[getX()][getY()].destroyShip();
                        enemyField[getX()][getY() + 1].destroyShip();
                    }
                }
            }
        }
    }

    @Override
    public void viewDestroyShipAI() {
        int y = (getX() - 75) / 25;
        int x = (getY() - 75) / 25;
        if (axis == 0) {
            for (int i = x - 1; i < x + 3; i++) {
                for (int j = y - 1; j < y + 2; j++) {
                    if ((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                        field[i][j].destroyShipArea();
                        field[x][y].destroyShip();
                        field[x + 1][y].destroyShip();
                    }
                }
            }
        }

        if (axis == 1) {
            for (int i = x - 1; i < x + 2; i++) {
                for (int j = y - 1; j < y + 3; j++) {
                    if ((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                        field[i][j].destroyShipArea();
                        field[x][y].destroyShip();
                        field[x][y + 1].destroyShip();
                    }
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       draggedX(e);
       draggedY(e);
    }

    public void draggedX(MouseEvent e) {
        if (gamePanel.getGame().getEnumAxis() == EnumAxis.AXIS_X) {
            if (getTest()) {
                setX(e.getX());
                setY(e.getY());
                gamePanel.getGame().convertMouseCordField(e);
                if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                    if ((getX() + getWidth() >= 100 & getX() + getWidth() <= 350) & (getY() + getHeigth() >= 100 & getY() + getHeigth() <= 350)) {
                        gamePanel.getGame().convertMouseCordField(e);
                        field = gamePanel.getField();
                        checkX();
                        if (check) {
                            setX(field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].getX());
                            setY(field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].getY());
                            setTextureShip(textureShipX);
                        } else {
                            setTextureShip(textureShipCantPutX);
                        }
                    } else {
                        setTextureShip(textureShipCantPutX);

                    }
                } else {
                    setTextureShip(textureShipCantPutX);
                }
            }
            check = true;
        }
    }

    public void draggedY(MouseEvent e) {
        if (gamePanel.getGame().getEnumAxis() == EnumAxis.AXIS_Y) {
            if (getTest()) {
                setX(e.getX());
                setY(e.getY());
                gamePanel.getGame().convertMouseCordField(e);
                if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                    if ((getX() + getHeigth() >= 100 & getX() + getHeigth() <= 350) & (getY() + getWidth() >= 100 & getY() + getWidth() <= 350)) {
                        gamePanel.getGame().convertMouseCordField(e);
                        field = gamePanel.getField();
                        checkY();
                        if (check) {
                            setX(field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].getX());
                            setY(field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].getY());
                            setTextureShip(textureShipY);
                        } else {
                            setTextureShip(textureShipCantPutY);
                        }
                    } else {
                        setTextureShip(textureShipCantPutY);

                    }
                } else {
                    setTextureShip(textureShipCantPutY);

                }
            }
            check = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       releasedX(e);
       releasedY(e);
    }

    public void releasedX(MouseEvent e) {
        if (gamePanel.getGame().getEnumAxis() == EnumAxis.AXIS_X) {
            if (getTest()) {
                axis = 0;
                if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                    if ((getX() + getWidth() >= 100 & getX() + getWidth() <= 350) & (getY() + getHeigth() >= 100 & getY() + getHeigth() <= 350)) {
                        checkX();
                        if (check) {
                            field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].setShip(this);
                            field[gamePanel.getGame().getConvertMouseX() + 1][gamePanel.getGame().getConvertMouseY()].setShip(this);
                            for (int i = gamePanel.getGame().getConvertMouseX() - 1; i < gamePanel.getGame().getConvertMouseX() + 3; i++) {
                                for (int j = gamePanel.getGame().getConvertMouseY() - 1; j < gamePanel.getGame().getConvertMouseY() + 2; j++) {
                                    if ((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                                        field[i][j].setBlock();
                                    }
                                }
                            }
                            setShipPut(true);
                        } else {
                            setX(initX);
                            setY(initY);
                            setTextureShip(textureShipX);
                        }
                    } else {
                        setX(initX);
                        setY(initY);
                        setTextureShip(textureShipX);
                    }
                } else {
                    setX(initX);
                    setY(initY);
                    setTextureShip(textureShipX);
                }
            }
            setTest(false);
        }
    }

    public void releasedY(MouseEvent e) {
        if (gamePanel.getGame().getEnumAxis() == EnumAxis.AXIS_Y) {
            if (getTest()) {
                axis = 1;
                if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                    if ((getX() + getHeigth() >= 100 & getX() + getHeigth() <= 350) & (getY() + getWidth() >= 100 & getY() + getWidth() <= 350)) {
                        checkY();
                        if (check) {
                            field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].setShip(this);
                            field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY() + 1].setShip(this);
                            for (int i = gamePanel.getGame().getConvertMouseX() - 1; i < gamePanel.getGame().getConvertMouseX() + 2; i++) {
                                for (int j = gamePanel.getGame().getConvertMouseY() - 1; j < gamePanel.getGame().getConvertMouseY() + 3; j++) {
                                    if ((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                                        field[i][j].setBlock();
                                    }
                                }
                            }
                            setShipPut(true);
                        } else {
                            setX(initX);
                            setY(initY);
                            setTextureShip(textureShipX);
                        }
                    } else {
                        setX(initX);
                        setY(initY);
                        setTextureShip(textureShipX);
                    }
                } else {
                    setX(initX);
                    setY(initY);
                    setTextureShip(textureShipX);
                }
            }
            setTest(false);
        }
    }

    public void checkX() {
        for(int i = gamePanel.getGame().getConvertMouseX(); i < gamePanel.getGame().getConvertMouseX() + 2; i++) {
            for(int j = gamePanel.getGame().getConvertMouseY(); j < gamePanel.getGame().getConvertMouseY() + 1; j++) {
                if((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                    if(field[i][j].getCheckBlock() == EnumCheckBlock.BLOCKED) {
                        check = false;
                    }
                }
            }
        }
    }

    public void checkY() {
        for(int i = gamePanel.getGame().getConvertMouseX(); i < gamePanel.getGame().getConvertMouseX() + 1; i++) {
            for(int j = gamePanel.getGame().getConvertMouseY(); j < gamePanel.getGame().getConvertMouseY() + 2; j++) {
                if((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                    if(field[i][j].getCheckBlock() == EnumCheckBlock.BLOCKED) {
                        check = false;
                    }
                }
            }
        }
    }

    public void locationAI() {
        axis = (int) (Math.random() * 2);
        System.out.println(axis);
        if (axis == 0) {
            while (getShipPut() == false) {
                setX((int) (Math.random() * 7));
                setY((int) (Math.random() * 10));
                boolean checkAI = true;
                enemyField = gamePanel.getEnemyField();
                for (int i = getX(); i < getX() + 3; i++) {
                    for (int j = getY(); j < getY() + 2; j++) {
                        if ((i < enemyField.length & i >= 0) & (j < enemyField.length & j >= 0)) {
                            if (enemyField[i][j].getCheckBlock() == EnumCheckBlock.BLOCKED) {
                                checkAI = false;
                            }
                        }
                    }
                }
                if (checkAI) {
                    for (int i = getX() - 1; i < getX() + 3; i++) {
                        for (int j = getY() - 1; j < getY() + 2; j++) {
                            if ((i < enemyField.length & i >= 0) & (j < enemyField.length & j >= 0)) {
                                enemyField[i][j].setBlock();
                            }
                        }
                    }
                    if ((getX() < enemyField.length & getX() >= 0) & (getY() < enemyField.length & getY() >= 0)) {
                        enemyField[getX()][getY()].setShip(this);
                        enemyField[getX() + 1][getY()].setShip(this);
                        setShipPut(true);
                    }
                }
            }
        }

        if (axis == 1) {
            while (getShipPut() == false) {
                setX((int) (Math.random() * 10));
                setY((int) (Math.random() * 7));
                boolean checkAI = true;
                enemyField = gamePanel.getEnemyField();
                for (int i = getX(); i < getX() + 2; i++) {
                    for (int j = getY(); j < getY() + 3; j++) {
                        if ((i < enemyField.length & i >= 0) & (j < enemyField.length & j >= 0)) {
                            if (enemyField[i][j].getCheckBlock() == EnumCheckBlock.BLOCKED) {
                                checkAI = false;
                            }
                        }
                    }
                }
                if (checkAI) {
                    for (int i = getX() - 1; i < getX() + 2; i++) {
                        for (int j = getY() - 1; j < getY() + 3; j++) {
                            if ((i < enemyField.length & i >= 0) & (j < enemyField.length & j >= 0)) {
                                enemyField[i][j].setBlock();
                            }
                        }
                    }
                    if ((getX() < enemyField.length & getX() >= 0) & (getY() < enemyField.length & getY() >= 0)) {
                        enemyField[getX()][getY()].setShip(this);
                        enemyField[getX()][getY() + 1].setShip(this);
                        setShipPut(true);
                    }
                }
            }
        }
    }
}
