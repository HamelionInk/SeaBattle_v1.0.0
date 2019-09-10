package com.noile.sea_battle.logic.game_process;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.cell.EnumCell;
import com.noile.sea_battle.logic.ships.Ships;
import com.noile.sea_battle.view.GamePanel;

public class LogicAI {

    private GamePanel gamePanel;

    private Cell field[][];

    private int AIX, AIY;

    private Ships shipTarget;

    public void targetOn() {

    }

    public LogicAI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;


        shipTarget = null;

        AIX = (int) (Math.random() * 10);
        AIY = (int) (Math.random() * 10);
    }

    public void targetOff() {
        while (true) {
            if (field[AIX][AIY].getEnumCell() == EnumCell.HIT) {
                shipTarget = field[AIX][AIY].getShips();
            }
            if (field[AIX][AIY].getEnumCell() == EnumCell.MISS) {
                AIX = (int) (Math.random() * 10);
                AIY = (int) (Math.random() * 10);
                System.out.println("____MISS");
                System.out.println(AIX);
                System.out.println(AIY);
                System.out.println("____MISS");
            }
            if (field[AIX][AIY].getEnumCell() == EnumCell.INITIAL) {
                field[AIX][AIY].EnemyMouseClicked();
                System.out.println("____HIT");
                System.out.println(AIX);
                System.out.println(AIY);
                System.out.println("____HIT");
                break;
            }
        }
    }

    public void step() {
        field = gamePanel.getField();
        if(shipTarget == null) {
            targetOff();
        }
        if(shipTarget != null) {
            targetOn();
        }
    }
}
