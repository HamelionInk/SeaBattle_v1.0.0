package com.noile.sea_battle.logic.ships;

import javax.swing.*;
import java.awt.*;

public class Cruiser extends Ships {

    public Cruiser() {
        setSize(3);
        setTextureShip(new ImageIcon("img/Ship/Cruiser.png"));

    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawImage(getImageShip().getImage(), 75,75,null);
    }
}
