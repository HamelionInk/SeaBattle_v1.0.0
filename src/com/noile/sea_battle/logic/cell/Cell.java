package com.noile.sea_battle.logic.cell;

import com.noile.sea_battle.view.GamePanel;

import javax.swing.*;

public class Cell{
    private ImageIcon texture;
    private ImageIcon textureHit;
    private ImageIcon textureMiss;

    private EnumCell enumCell;
    private EnumCellHaveShip enumCellHaveShip;

    private GamePanel game;

    private int x, y;
    private int heigth, width;

    public Cell(int x, int y, GamePanel game) {

        texture = new ImageIcon("img/Cell/Sea.png");
        textureHit = new ImageIcon("img/Cell/Hit.png");
        textureMiss = new ImageIcon("img/Cell/Miss.png");

        enumCell = EnumCell.INITIAL;
        enumCellHaveShip = EnumCellHaveShip.SEA;

        heigth = 25;
        width = 25;

        this.x = x;
        this.y = y;
        this.game = game;
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

    public void test() {
        enumCellHaveShip = EnumCellHaveShip.SHIP;
    }

    public void mouseClicked() {
           if(enumCellHaveShip == EnumCellHaveShip.SHIP) {
               enumCell = EnumCell.HIT;
           } else {
               enumCell = EnumCell.MISS;
           }
       }
}





