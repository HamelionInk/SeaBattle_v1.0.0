package com.noile.sea_battle.logic.game_process;

import com.noile.sea_battle.view.MainFrame;

import java.awt.event.MouseEvent;

public class Game {

    private EnumGameStage gameStage;

    private int convertMouseX, convertMouseY;

    public Game() {
        gameStage = EnumGameStage.LOCATION_STAGE;
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

    public void setGameStage(EnumGameStage gameStage) {
        this.gameStage = gameStage;
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    public void convertMouseCordEnemyField(MouseEvent e) {
        convertMouseY = ((e.getX() - 75) / 25);
        convertMouseX = ((e.getY() - 375) / 25);
    }

    public void convertMouseCordField(MouseEvent e) {
        convertMouseY = ((e.getX() - 75) / 25);
        convertMouseX = ((e.getY() - 75) / 25);
    }
}


