package com.noile.sea_battle.logic.game_process;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.view.GamePanel;
import com.noile.sea_battle.view.MainFrame;

import java.awt.event.MouseEvent;

public class Game {

    private GamePanel gamePanel;

    private EnumGameStage gameStage;
    private EnumAxis enumAxis;

    private int convertMouseX, convertMouseY;
    private int AIX, AIY;

    private Cell field[][];
    private Cell enemyField[][];


    public Game(GamePanel gamePanel) {
        gameStage = EnumGameStage.LOCATION_STAGE;
        enumAxis = EnumAxis.AXIS_X;

        this.gamePanel = gamePanel;

        AIX = (int) (Math.random() * 10);
        AIY = (int) (Math.random() * 10);
    }

    public int getConvertMouseX() {
        return convertMouseX;
    }

    public int getConvertMouseY() {
        return convertMouseY;
    }

    public EnumGameStage getGameStage() {
        return gameStage;
    }

    public EnumAxis getEnumAxis() {
        return enumAxis;
    }

    public void setEnumAxis(EnumAxis enumAxis) {
        this.enumAxis = enumAxis;
    }

    public void setGameStage(EnumGameStage gameStage) {
        this.gameStage = gameStage;
    }

    public void myStep(MouseEvent e) {
        enemyField = gamePanel.getEnemyField();
        if ((e.getX() > 75 & e.getX() < 325) & (e.getY() > 375 & e.getY() < 625)) {
            convertMouseCordEnemyField(e);
            if (enemyField[getConvertMouseX()][getConvertMouseY()].getHaveHit() == false) {
                enemyField[getConvertMouseX()][getConvertMouseY()].mouseClicked();
            }
        }
    }

    public void enemyStep() {
        field = gamePanel.getField();
        field[AIX][AIY].mouseClicked();

    }

    public void convertMouseCordEnemyField(MouseEvent e) {
        convertMouseY = ((e.getX() - 75) / 25);
        convertMouseX = ((e.getY() - 375) / 25);
    }

    public void convertMouseCordField(MouseEvent e) {
        convertMouseY = ((e.getX() - 75) / 25);
        convertMouseX = ((e.getY() - 75) / 25);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}


