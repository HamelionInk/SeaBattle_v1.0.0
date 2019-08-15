package com.noile.sea_battle.logic.ships;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.cell.EnumCheckBlock;
import com.noile.sea_battle.logic.game_process.EnumAxis;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Destroyer extends Ships {

    private GamePanel gamePanel;
    private Cell field[][];

    private ImageIcon textureShipX;
    private ImageIcon textureShipY;
    private ImageIcon textureShipCantPutX;
    private ImageIcon textureShipCantPutY;

    private int initX, initY;

    private boolean check;

    public Destroyer(int x, int y, GamePanel gamePanel) {

        textureShipX = new ImageIcon("img/Ship/DestroyerX.png");
        textureShipY = new ImageIcon("img/Ship/DestroyerY.png");
        textureShipCantPutX = new ImageIcon("img/Ship/DestroyerCantPutX.png");
        textureShipCantPutY = new ImageIcon("img/Ship/DestroyerCantPutY.png");


        setTextureShip(textureShipX);

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
        draggedX(e);
        draggedY(e);
    }


    public void draggedX(MouseEvent e) {
        if (gamePanel.getGame().getEnumAxis() == EnumAxis.AXIS_X) {
            if (getTest()) {
                setX(e.getX());
                setY(e.getY());
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
                if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                    if ((getX() + getWidth() >= 75 & getX() + getWidth() <= 325) & (getY() + getHeigth() >= 75 & getY() + getHeigth() <= 325)) {
                        checkX();
                        if (check) {
                            field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].checkShip();
                            field[gamePanel.getGame().getConvertMouseX() + 1][gamePanel.getGame().getConvertMouseY()].checkShip();
                            field[gamePanel.getGame().getConvertMouseX() + 2][gamePanel.getGame().getConvertMouseY()].checkShip();
                            field[gamePanel.getGame().getConvertMouseX() + 3][gamePanel.getGame().getConvertMouseY()].checkShip();
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
                if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 75 & e.getY() < 325)) {
                    if ((getX() + getHeigth() >= 100 & getX() + getHeigth() <= 350) & (getY() + getWidth() >= 100 & getY() + getWidth() <= 350)) {
                        checkY();
                        if (check) {
                            field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY()].checkShip();
                            field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY() + 1].checkShip();
                            field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY() + 2].checkShip();
                            field[gamePanel.getGame().getConvertMouseX()][gamePanel.getGame().getConvertMouseY() + 3].checkShip();
                            for (int i = gamePanel.getGame().getConvertMouseX() - 1; i < gamePanel.getGame().getConvertMouseX() + 2; i++) {
                                for (int j = gamePanel.getGame().getConvertMouseY() - 1; j < gamePanel.getGame().getConvertMouseY() + 5; j++) {
                                    if ((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                                        field[i][j].checkBlock();
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
        for(int i = gamePanel.getGame().getConvertMouseX(); i < gamePanel.getGame().getConvertMouseX() + 4; i++) {
            for(int j = gamePanel.getGame().getConvertMouseY(); j < gamePanel.getGame().getConvertMouseY() + 1; j++) {
                if((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                    if(field[i][j].getEnumCheckBlock() == EnumCheckBlock.BLOCKED) {
                        check = false;
                    }
                }
            }
        }
    }

    public void checkY() {
        for(int i = gamePanel.getGame().getConvertMouseX(); i < gamePanel.getGame().getConvertMouseX() + 1; i++) {
            for(int j = gamePanel.getGame().getConvertMouseY(); j < gamePanel.getGame().getConvertMouseY() + 4; j++) {
                if((i < field.length & i >= 0) & (j < field.length & j >= 0)) {
                    if(field[i][j].getEnumCheckBlock() == EnumCheckBlock.BLOCKED) {
                        check = false;
                    }
                }
            }
        }
    }
}
