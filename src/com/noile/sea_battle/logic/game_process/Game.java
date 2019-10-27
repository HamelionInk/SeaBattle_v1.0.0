package com.noile.sea_battle.logic.game_process;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.cell.EnumCell;
import com.noile.sea_battle.logic.ships.Ships;
import com.noile.sea_battle.view.GamePanel;
import com.noile.sea_battle.view.MainFrame;

import java.awt.event.MouseEvent;

public class Game {

    private LogicAI logicAI;

    private GamePanel gamePanel;

    private EnumGameStage gameStage;
    private EnumAxis enumAxis;

    private int convertMouseX, convertMouseY;

    public Game(GamePanel gamePanel) {
        logicAI = new LogicAI(gamePanel);

        gameStage = EnumGameStage.LOCATION_STAGE;
        enumAxis = EnumAxis.AXIS_X;

        this.gamePanel = gamePanel;
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

    public void step(MouseEvent e) {
        convertMouseCordEnemyField(e);
        if (gamePanel.getEnemyField()[getConvertMouseX()][getConvertMouseY()].getEnumCell() == EnumCell.INITIAL) {
            gamePanel.getEnemyField()[getConvertMouseX()][getConvertMouseY()].mouseClicked();
            logicAI.step();
        }
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


