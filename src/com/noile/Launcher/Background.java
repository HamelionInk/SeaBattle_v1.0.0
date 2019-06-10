package com.noile.Launcher;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {

    private ImageIcon background = new ImageIcon("img/mainFrame.jpg");

    private JButton startButton = new MenuButton(
            "img/Button/StartButtonRollover.png",
            "img/Button/StartButtonPressed.png",
            "img/Button/ButtonStart.png"
    );
    private JButton optionsButton = new MenuButton(
            "img/Button/ButtonOptionsRollover.png",
            "img/Button/ButtonOptionsPressed.png",
            "img/Button/ButtonOptions.png"
    );
    private JButton recordsButton = new MenuButton(
            "img/Button/ButtonRecordsRollover.png",
            "img/Button/ButtonRecordsPressed.png",
            "img/Button/ButtonRecords.png"
    );
    private JButton exitButton = new MenuButton(
            "img/Button/ButtonExitRollover.png",
            "img/Button/ButtonExitPressed.png",
            "img/Button/ButtonExit.png"
    );

    public Background() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(startButton, gbc);
        add(optionsButton, gbc);
        add(recordsButton, gbc);
        add(exitButton, gbc);

        startButton.addActionListener(actionEvent -> {
            GamePanelEnum.GAME_PANEL.show();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background.getImage(), 0, 0, null);
        g2d.drawImage(new ImageIcon("img/Font.png").getImage(), 0, 0, null);
        g2d.drawImage(new ImageIcon("img/SeaBattles.png").getImage(), 300, 50, null);

    }


}
