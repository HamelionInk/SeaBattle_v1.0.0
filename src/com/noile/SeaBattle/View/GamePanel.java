package com.noile.SeaBattle.View;

import com.noile.SeaBattle.Logic.TakeShip;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    ArrayList<CellPane> fieldPanelList = new ArrayList<>();

    TakeShip takeShip = new TakeShip(fieldPanelList);

    FieldPanel fieldPanel = new FieldPanel(takeShip, fieldPanelList);
    FieldPanel fieldPanelEnemy = new FieldPanel(takeShip, fieldPanelList);

    ShipsView testBoat = new ShipsView(takeShip);

    public GamePanel() {
        setLayout(null);

        fieldPanel.setBounds(50,50,250,250);
        fieldPanelEnemy.setBounds(50,350,250,250);

        testBoat.setBounds(500,500, 100,50);

        add(fieldPanel);
        add(fieldPanelEnemy);
        add(testBoat);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(new ImageIcon("img/GamePanelFont.jpg").getImage(),0,0,null);
    }
}
