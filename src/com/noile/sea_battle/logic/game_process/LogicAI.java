package com.noile.sea_battle.logic.game_process;

import com.noile.sea_battle.logic.cell.EnumCell;
import com.noile.sea_battle.logic.ships.Ships;
import com.noile.sea_battle.view.GamePanel;

public class LogicAI {
    private GamePanel gamePanel;

    private int AIX, AIY;

    private Ships shipTarget;

    private int count = -1;
    private int coordAttack;

    private boolean AXISX = false;
    private boolean AXISY = false;
    private boolean change = false;

    public LogicAI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        shipTarget = null;

        AIX = (int) (Math.random() * 10);
        AIY = (int) (Math.random() * 10);
    }

    public void spotShot() {
        coordAttack = (int) (Math.random() * 4);
    }

    public void foundLocationShip() {
        switch (coordAttack) {
            case 0:
                AIX = AIX + 1;
                if(AIX < 0 | AIX >= 10) {
                    AIX = AIX - 1;
                    spotShot();
                } else {
                    if(gamePanel.getField()[AIX][AIY].getShips() != null) {
                        gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                        change = true;
                    }
                    AIX = AIX - 1;
                }
                break;
            case 1:
                AIX = AIX - 1;
                if(AIX < 0 | AIX >= 10) {
                    AIX = AIX + 1;
                    spotShot();
                } else {
                    if(gamePanel.getField()[AIX][AIY].getShips() != null) {
                        gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                        change = true;
                    }
                    AIX = AIX + 1;
                }
                break;
            case 2:
                AIY = AIY + 1;
                if(AIY < 0 | AIY >= 10) {
                    AIY = AIY - 1;
                    spotShot();
                } else {
                    if(gamePanel.getField()[AIX][AIY].getShips() != null) {
                        gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                        change = true;
                    }
                    AIY = AIY - 1;
                }
                break;
            case 3:
                AIY = AIY - 1;
                if(AIY < 0 | AIY >= 10) {
                    AIY = AIY + 1;
                    spotShot();
                } else {
                    if(gamePanel.getField()[AIX][AIY].getShips() != null) {
                        gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                        change = true;
                    }
                    AIY = AIY + 1;
                }
                break;
        }
    }

    public void attackHorizontal() {

    }

    public void attackVertical() {

    }

    public void targetOn() {
        spotShot();
        do {
            spotShot();
            foundLocationShip();
        } while (change == false);

        if(AXISX) {
            attackVertical();
        }
        if(AXISY) {
            attackHorizontal();
        }

        if(shipTarget.isDestroy()) {
            AXISX = false;
            AXISY = false;
            change = false;
            shipTarget = null;
            count = -1;
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
        if(shipTarget == null) {
            targetOff();
        }
        if(shipTarget != null) {
            count++;
            System.out.println(count);
            targetOn();
        }
    }
}
