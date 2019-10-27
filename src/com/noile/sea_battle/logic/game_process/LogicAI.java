package com.noile.sea_battle.logic.game_process;

import com.noile.sea_battle.logic.cell.Cell;
import com.noile.sea_battle.logic.cell.EnumCell;
import com.noile.sea_battle.logic.ships.Ships;
import com.noile.sea_battle.view.GamePanel;

public class LogicAI {
    private GamePanel gamePanel;

    private int AIX, AIY;

    private Ships shipTarget;

    private int count = 0;


    public LogicAI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        shipTarget = null;

        AIX = (int) (Math.random() * 10);
        AIY = (int) (Math.random() * 10);
    }

    public void targetOn() {
        gamePanel.getField()[AIX + 1][AIY].EnemyMouseClicked();
            if(gamePanel.getField()[AIX + 1][AIY].getEnumCell() == EnumCell.MISS) {
                gamePanel.getField()[AIX - 1][AIY].EnemyMouseClicked();
                if(gamePanel.getField()[AIX - 1][AIY].getEnumCell() == EnumCell.MISS) {
                    if(gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.MISS) {

                    }

                    if(gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.HIT) {

                    }
                }

                if(gamePanel.getField()[AIX - 1][AIY].getEnumCell() == EnumCell.HIT) {
                    gamePanel.getField()[AIX - 2][AIY].EnemyMouseClicked();

                    if(gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.MISS) {

                    }
                }
            }

            if(gamePanel.getField()[AIX + 1][AIY].getEnumCell() == EnumCell.HIT) {
                gamePanel.getField()[AIX + 2][AIY].EnemyMouseClicked();
                if(gamePanel.getField()[AIX + 2][AIY].getEnumCell() == EnumCell.MISS) {
                    gamePanel.getField()[AIX - 1][AIY].EnemyMouseClicked();
                    if(gamePanel.getField()[AIX - 1][AIY].getEnumCell() == EnumCell.HIT) {
                        gamePanel.getField()[AIX - 2][AIY].EnemyMouseClicked();

                    }
                }

                if(gamePanel.getField()[AIX + 2][AIY].getEnumCell() == EnumCell.HIT) {
                    gamePanel.getField()[AIX + 3][AIY].EnemyMouseClicked();

                }
            }


            if(shipTarget.isDestroy()) {
                shipTarget = null;
                count = 0;
                AIX = (int) (Math.random() * 10);
                AIY = (int) (Math.random() * 10);
            }
    }

    public void targetOff() {
        while (true) {
            if (gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.HIT) {
                shipTarget = gamePanel.getField()[AIX][AIY].getShips();
                break;
            }
            if (gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.MISS) {
                AIX = (int) (Math.random() * 10);
                AIY = (int) (Math.random() * 10);
            }
            if (gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.INITIAL) {
                gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                break;
            }
        }
    }

    public void step() {
        count++;
        if(shipTarget == null) {
            targetOff();
        }
        if(shipTarget != null) {
            targetOn();
        }
    }
}
