package com.noile.Launcher;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {

     ImageIcon background = new ImageIcon("img/mainFrame.jpg");

     @Override
     protected void paintComponent(Graphics g) {
         Graphics2D g2d = (Graphics2D) g;
         g2d.drawImage(background.getImage(), 0, 0, null);
         g2d.drawImage(new ImageIcon("img/Font.png").getImage(), 0,0,null);
         g2d.drawImage(new ImageIcon("img/SeaBattles.png").getImage(), 300,50,null);

    }
}
