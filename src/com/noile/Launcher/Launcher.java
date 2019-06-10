package com.noile.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher extends JComponent{

    ImageIcon logo = new ImageIcon("img/frameIcon.jpg");
    JFrame mainFrame = new JFrame("Sea Battles - v1.0.0");
    Background background = new Background();
    GamePanel gamePanel = new GamePanel();
    JPanel switchPanel = new JPanel(new CardLayout());



    JButton startButton = new JButton();
    JButton optionsButton = new JButton();
    JButton recordsButton = new JButton();
    JButton exitButton = new JButton();

    JButton test1 = new JButton("test");

    public void getButtonBG() {

        startButton.setBorder(null);
        startButton.setBorderPainted(false);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setRolloverIcon(new ImageIcon("img/Button/StartButtonRollover.png"));
        startButton.setPressedIcon(new ImageIcon("img/Button/StartButtonPressed.png"));
        startButton.setIcon(new ImageIcon("img/Button/ButtonStart.png"));
        startButton.addActionListener(new MyStartListener());

        optionsButton.setBorder(null);
        optionsButton.setBorderPainted(false);
        optionsButton.setOpaque(false);
        optionsButton.setContentAreaFilled(false);
        optionsButton.setRolloverIcon(new ImageIcon("img/Button/ButtonOptionsRollover.png"));
        optionsButton.setPressedIcon(new ImageIcon("img/Button/ButtonOptionsPressed.png"));
        optionsButton.setIcon(new ImageIcon("img/Button/ButtonOptions.png"));

        recordsButton.setBorder(null);
        recordsButton.setBorderPainted(false);
        recordsButton.setOpaque(false);
        recordsButton.setContentAreaFilled(false);
        recordsButton.setRolloverIcon(new ImageIcon("img/Button/ButtonRecordsRollover.png"));
        recordsButton.setPressedIcon(new ImageIcon("img/Button/ButtonRecordsPressed.png"));
        recordsButton.setIcon(new ImageIcon("img/Button/ButtonRecords.png"));

        exitButton.setBorder(null);
        exitButton.setBorderPainted(false);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setRolloverIcon(new ImageIcon("img/Button/ButtonExitRollover.png"));
        exitButton.setPressedIcon(new ImageIcon("img/Button/ButtonExitPressed.png"));
        exitButton.setIcon(new ImageIcon("img/Button/ButtonExit.png"));
    }

    public void getButtonGP() {
        test1.setBorder(null);
        test1.setBorderPainted(false);
        test1.setOpaque(false);
        test1.setContentAreaFilled(false);
        test1.setRolloverIcon(new ImageIcon("img/Button/ButtonExitRollover.png"));
        test1.setPressedIcon(new ImageIcon("img/Button/ButtonExitPressed.png"));
        test1.setIcon(new ImageIcon("img/Button/ButtonExit.png"));
        test1.addActionListener(new MyTestListener());
    }


    public void getFrame() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        mainFrame.setBounds(dimension.width/2 - 640, dimension.height/2 - 512, 1280,1024);
        mainFrame.setIconImage(logo.getImage());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.add(switchPanel);
        mainFrame.setVisible(true);

        switchPanel.add(background);
        switchPanel.add(gamePanel);

        gamePanel.setVisible(false);
        gamePanel.add(test1);

        background.setVisible(true);
        background.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        background.add(startButton, gbc);
        background.add(optionsButton, gbc);
        background.add(recordsButton, gbc);
        background.add(exitButton, gbc);

    }


    public static void main(String[] args){
        Launcher launcher = new Launcher();
        launcher.getButtonGP();
        launcher.getButtonBG();
        launcher.getFrame();

    }

    class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            background.setVisible(false);
            gamePanel.setVisible(true);
        }
    }

    class MyTestListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            background.setVisible(true);
            gamePanel.setVisible(false);
        }
    }
}
