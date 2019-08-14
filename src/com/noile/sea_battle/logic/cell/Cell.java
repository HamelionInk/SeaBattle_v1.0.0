package com.noile.sea_battle.logic.cell;

import com.noile.sea_battle.logic.game_process.EnumGameStage;
import com.noile.sea_battle.logic.game_process.Game;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Cell{
    private ImageIcon texture;
    private ImageIcon textureSea;
    private ImageIcon textureHit;
    private ImageIcon textureMiss;
    private ImageIcon textureMouseEntered;
    private ImageIcon tempTexture;

    private EnumCell enumCell;
    private EnumCellHaveShip enumCellHaveShip;
    private EnumCheckBlock enumCheckBlock;

    private Game game;

    private int x, y;

    public Cell(int x, int y, Game game) {

        textureSea = new ImageIcon("img/Cell/Sea.png");
        textureHit = new ImageIcon("img/Cell/Hit.png");
        textureMiss = new ImageIcon("img/Cell/Miss.png");
        textureMouseEntered = new ImageIcon("img/Cell/Entered.png");
        texture = textureSea;

        enumCell = EnumCell.INITIAL;
        enumCellHaveShip = EnumCellHaveShip.SEA;
        enumCheckBlock = EnumCheckBlock.UNBLOCKED;

        this.x = x;
        this.y = y;
        this.game = game;
    }

    public void setTempTexture(ImageIcon tempTexture) {
        this.tempTexture = tempTexture;
    }

    public ImageIcon getTexture() {
        return texture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public EnumCheckBlock getEnumCheckBlock() {
        return enumCheckBlock;
    }

    public void state() {
        switch (enumCell) {
            case HIT:
                texture = textureHit;
                break;
            case MISS:
                texture = textureMiss;
                break;
        }
    }

    public void checkShip() {
        enumCellHaveShip = EnumCellHaveShip.SHIP;
    }

    public void checkBlock() {
        enumCheckBlock = EnumCheckBlock.BLOCKED;
        texture = textureMiss;
    }

    public void mouseClicked() {
        if (game.getGameStage() == EnumGameStage.BATTLE_STAGE) {
            if (enumCellHaveShip == EnumCellHaveShip.SHIP) {
                enumCell = EnumCell.HIT;
            } else {
                enumCell = EnumCell.MISS;
            }
        }
           state();
    }

    public void mouseEntered(MouseEvent e) {
        setTempTexture(texture);
        texture = textureMouseEntered;
    }

    public void mouseExited(MouseEvent e) {
        if ((e.getX() > getX() & e.getX() < getX()) & (e.getY() > getY() & e.getY() < getY())) {
            texture = tempTexture;
        }

    }

}





