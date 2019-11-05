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

    private boolean change = false;
    private boolean AxisX = false;
    private boolean AxisY = false;

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
                    if(gamePanel.getField()[AIX][AIY].getShips() != null & gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.INITIAL)  {
                        gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                        change = true;
                        AxisX = true;
                    }
                }
                break;
            case 1:
                AIX = AIX - 1;
                if(AIX < 0 | AIX >= 10) {
                    AIX = AIX + 1;
                    spotShot();
                } else {
                    if(gamePanel.getField()[AIX][AIY].getShips() != null & gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.INITIAL) {
                        gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                        change = true;
                        AxisX = true;
                    }
                }
                break;
            case 2:
                AIY = AIY + 1;
                if(AIY < 0 | AIY >= 10) {
                    AIY = AIY - 1;
                    spotShot();
                } else {
                    if(gamePanel.getField()[AIX][AIY].getShips() != null & gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.INITIAL) {
                        gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                        change = true;
                        AxisY = true;
                    }
                }
                break;
            case 3:
                AIY = AIY - 1;
                if(AIY < 0 | AIY >= 10) {
                    AIY = AIY + 1;
                    spotShot();
                } else {
                    if(gamePanel.getField()[AIX][AIY].getShips() != null & gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.INITIAL) {
                        gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
                        change = true;
                        AxisY = true;
                    }
                }
                break;
        }
    }

    public void targetOn() {
        spotShot();
        while (change == false) {
            spotShot();
            foundLocationShip();
            System.out.println("work");
        }

      //  if (AxisX) {
//
      //  }
      //  if (AxisY) {
      //     AIY = AIY + 1;
      //     if(AIY > 0 & AIY < 10) {
      //         gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
      //         if(gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.MISS) {
      //             AIY = AIY - 2;
      //             if(AIY > 0 & AIY < 10) {
      //                 gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
      //                 if(gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.HIT) {
      //                     AIY = AIY - 1;
      //                     if(AIY > 0 & AIY < 10) {
      //                         gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
      //                     }
      //                 }
      //             }
      //         }
      //         if(gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.HIT) {
      //             AIY = AIX + 1;
      //             if(AIY > 0 & AIY < 10) {
      //                 gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
      //                 if (gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.HIT) {
      //                     AIY = AIX + 1;
      //                     if (AIY > 0 & AIY < 10) {
      //                         gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
      //                     }
      //                 }
      //                 if (gamePanel.getField()[AIX][AIY].getEnumCell() == EnumCell.MISS) {
      //                     AIY = AIX - 2;
      //                     if (AIY > 0 & AIY < 10) {
      //                         gamePanel.getField()[AIX][AIY].EnemyMouseClicked();
      //                     }
      //                 }
      //             }
      //         }
      //     }
      //  }

        if(shipTarget.isDestroy()) {
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
            change = false;
            System.out.println(count);
            targetOn();
        }
    }
}
