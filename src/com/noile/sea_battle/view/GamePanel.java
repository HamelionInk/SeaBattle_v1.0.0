package com.noile.sea_battle.view;

import com.noile.sea_battle.logic.PutShip;
import com.noile.sea_battle.view.button.AxisButton;
import com.noile.sea_battle.view.button.ShipButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {


    ArrayList<CellPane> fieldPanelList = new ArrayList<>();
    ArrayList<CellPane> fieldPanelListEnemy = new ArrayList<>();

    PutShip putShip = new PutShip(fieldPanelList);
    PutShip putShipEnemy = new PutShip(fieldPanelListEnemy);

    FieldPanel fieldPanel = new FieldPanel(fieldPanelList, putShip);
    FieldPanel fieldPanelEnemy = new FieldPanel(fieldPanelListEnemy, putShip);

    ShipButton destroyer = new ShipButton("Destroyer", putShip);
    ShipButton submarine = new ShipButton("Submarine", putShip);
    ShipButton cruiser = new ShipButton("Cruiser", putShip);
    ShipButton boat = new ShipButton("Boat", putShip);

    AxisButton axis = new AxisButton("Axis X",putShip);


    public GamePanel() {
        setLayout(null);

        fieldPanel.setBounds(50,50,250,250);
        fieldPanelEnemy.setBounds(50,350,250,250);

        boat.setBounds(400,400,100,50);
        cruiser.setBounds(400, 350, 100,50);
        submarine.setBounds(400, 300,100,50);
        destroyer.setBounds(400,250, 100, 50);
        axis.setBounds(400,150, 100, 50);


        add(fieldPanel);
        add(fieldPanelEnemy);
        add(boat);
        add(cruiser);
        add(submarine);
        add(destroyer);
        add(axis);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(new ImageIcon("img/Font.jpg").getImage(),0,0,null);
    }
}
