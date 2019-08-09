package com.noile.sea_battle.logic.ships;

import javax.swing.*;
import java.awt.*;

public abstract class Ships {
    private int size;
    private ImageIcon textureShip;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTextureShip(ImageIcon textureShip) {
        this.textureShip = textureShip;
    }

    public ImageIcon getImageShip() {
        return textureShip;
    }

    public abstract void render(Graphics2D g2d);
}
