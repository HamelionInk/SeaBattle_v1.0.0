package com.noile.Launcher;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JComponent {

    private ImageIcon logo = new ImageIcon("img/frameIcon.jpg");
    private JFrame mainFrame = new JFrame("Sea Battles - v1.0.0");

    private JPanel switchPanel = new JPanel(new CardLayout());


    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.getFrame();
    }

    public void getFrame() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        mainFrame.setBounds(dimension.width / 2 - 640, dimension.height / 2 - 512, 1280, 1024);
        mainFrame.setIconImage(logo.getImage());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.add(switchPanel);
        mainFrame.setVisible(true);

        for (GamePanelEnum value : GamePanelEnum.values()) {
            switchPanel.add(value.getPanel());
        }

    }

}
