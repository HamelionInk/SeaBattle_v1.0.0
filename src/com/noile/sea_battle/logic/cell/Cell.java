package com.noile.sea_battle.logic.cell;

import com.noile.sea_battle.logic.game_process.EnumGameStage;
import com.noile.sea_battle.logic.game_process.Game;
import com.noile.sea_battle.logic.ships.Ships;
import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Cell{
    private ImageIcon texture;
    private ImageIcon textureSea;
    private ImageIcon textureHit;
    private ImageIcon textureMiss;

    private EnumCell enumCell;
    private EnumCheckBlock enumCheckBlock;

    private Ships ships;

    private Game game;

    private int x, y;

    private boolean haveHit;

    public Cell(int x, int y, Game game) {

        textureSea = new ImageIcon("img/Cell/Sea.png");
        textureHit = new ImageIcon("img/Cell/Hit.png");
        textureMiss = new ImageIcon("img/Cell/Miss.png");
        texture = textureSea;

        enumCell = EnumCell.INITIAL;
        enumCheckBlock = EnumCheckBlock.UNBLOCKED;

        haveHit = false;

        this.x = x;
        this.y = y;
        this.game = game;
    }

    public ImageIcon getTexture() {
        return texture;
    }

    public boolean getHaveHit() {
        return haveHit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public EnumCheckBlock getCheckBlock() {
        return enumCheckBlock;
    }

    public EnumCell getEnumCell() {
        return enumCell;
    }

    public Ships getShips() {
        return ships;
    }

    public void setShip(Ships ships) {
        this.ships = ships;
    }

    public void setBlock() {
        enumCheckBlock = EnumCheckBlock.BLOCKED;
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

    public void destroyShipArea() {
        texture = textureMiss;
    }

    public void destroyShip() {
        texture = textureHit;
    }

    public void mouseClicked() {
        if (game.getGameStage() == EnumGameStage.BATTLE_STAGE) {
            if (ships != null) {
                enumCell = EnumCell.HIT;
                if(haveHit == false) {
                    ships.takeDamage();
                }
            } else {
                enumCell = EnumCell.MISS;
                haveHit = true;
            }
        }
           state();
    }

    public void EnemyMouseClicked() {
        if (game.getGameStage() == EnumGameStage.BATTLE_STAGE) {
            if (ships != null) {
                enumCell = EnumCell.HIT;
                if(haveHit == false) {
                    ships.EnemyTakeDamage();
                }
            } else {
                enumCell = EnumCell.MISS;
                haveHit = true;
            }
        }
        state();
    }
}





