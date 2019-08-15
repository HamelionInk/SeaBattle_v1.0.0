package com.noile.sea_battle.logic.game_process;

import com.noile.sea_battle.view.MainFrame;

import java.awt.event.MouseEvent;

public class Game {

    private EnumGameStage gameStage;
    private EnumAxis enumAxis;

    private int convertMouseX, convertMouseY;

    public Game() {
        gameStage = EnumGameStage.LOCATION_STAGE;
        enumAxis = EnumAxis.AXIS_X;
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


