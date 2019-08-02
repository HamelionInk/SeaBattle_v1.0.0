package com.noile.sea_battle.view;

import com.noile.sea_battle.view.button.MenuButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MenuPanel extends JPanel {

    Image imgTest;

    ImageIcon img = new ImageIcon("img/GamePanelFont.jpg");

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

    public MenuPanel() {
        revalidate();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(startButton, gbc);
        add(optionsButton, gbc);
        add(recordsButton, gbc);
        add(exitButton, gbc);

        startButton.addActionListener(actionEvent -> {
            SwitchEnum.GAME_PANEL.show();
        });

        optionsButton.addActionListener(actionEvent -> {
            SwitchEnum.OPTIONS_PANEL.show();
        });

        recordsButton.addActionListener(actionEvent -> {
            SwitchEnum.RECORDS_PANEL.show();
        });

        try {
            imgTest = ImageIO.read(new File("img/GamePanelFont.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static double getScaleFactor(int iMasterSize, int iTargetSize) {
        double dScale;
        if (iMasterSize > iTargetSize) {
            dScale = (double) iTargetSize / (double) iMasterSize;
        } else {
            dScale = (double) iTargetSize / (double) iMasterSize;
        }
        return dScale;

    }

    public static double getScaleFactorToFill(Dimension masterSize, Dimension targetSize) {

        double dScaleWidth = getScaleFactor(masterSize.width, targetSize.width);
        double dScaleHeight = getScaleFactor(masterSize.height, targetSize.height);

        double dScale = Math.max(dScaleHeight, dScaleWidth);

        return dScale;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

            double scaleFactor = Math.min(1d, getScaleFactorToFill(new Dimension(imgTest.getWidth(null), imgTest.getHeight(null)), getSize()));

            int scaleWidth = (int) Math.round(imgTest.getWidth(null) * scaleFactor);
            int scaleHeight = (int) Math.round(imgTest.getHeight(null) * scaleFactor);

            Image scaled = imgTest.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_FAST);

            int width = getWidth() - 1;
            int height = getHeight() - 1;

            int x = (width - scaled.getWidth(this)) / 2;
            int y = (height - scaled.getHeight(this)) / 2;

            g.drawImage(scaled, x, y, null);
    }
}
// попробовать создать свой класс для картинок наседовать от Image и запилить все это туда, чтобы применять к каждой
// создаваемой картинки