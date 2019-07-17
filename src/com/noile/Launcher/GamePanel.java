package com.noile.Launcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    int x = 35; //77
    int y = 42; //84

    private ImageIcon gamePanelFont = new ImageIcon("img/GamePanelFont.jpg");
    private ImageIcon field = new ImageIcon("img/test2.png");
    private ImageIcon rama = new ImageIcon("img/rama.png");

    private MenuButton exitButton = new MenuButton(
            "img/Button/ButtonExitRollover.png",
            "img/Button/ButtonExitPressed.png",
            "img/Button/ButtonExit.png"
    );

    public GamePanel() {
        setLayout(null);
        exitButton.setBounds(500,400,50,50);
        add(exitButton);

        for(int countX = 0; countX < 9; countX++) {
            y = y + 42;
            x = 35;
            for(int countY = 0; countY < 9; countY++) {
                x = x + 42;
                add(new BattleField("img/Button/ButtonExitRollover.png",
                    "img/Button/ButtonExitPressed.png",
                    "img/just.png",
                    x , y));
            }
        }

        y = 522;
        for(int countX = 0; countX < 9; countX++) {
            y = y + 42;
            x = 35;
            for(int countY = 0; countY < 9; countY++) {
                x = x + 42;
                add(new BattleField("img/Button/ButtonExitRollover.png",
                        "img/Button/ButtonExitPressed.png",
                        "img/just.png",
                        x , y));
            }
        }

        exitButton.addActionListener(actionEvent ->
                GamePanelEnum.BACKGROUND.show());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(gamePanelFont.getImage(), 0,0,null);
        g2d.drawImage(field.getImage(), 23,30,null);
        g2d.drawImage(field.getImage(), 23,510,null);
        g2d.drawImage(rama.getImage(), 0,482,null);
        g2d.drawImage(rama.getImage(), 0,2,null);
    }
}


