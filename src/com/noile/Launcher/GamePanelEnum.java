package com.noile.Launcher;

import javax.swing.*;

public enum GamePanelEnum {

    BACKGROUND {

        private Background background = new Background();

        @Override
        JPanel getPanel() {
            return background;
        }

        @Override
        void show() {
            setVisible(this);
        }
    },

    GAME_PANEL {

        private GamePanel gamePanel = new GamePanel();

        @Override
        JPanel getPanel() {
            return gamePanel;
        }

        @Override
        void show() {
            setVisible(this);
        }
    };

    abstract JPanel getPanel();

    abstract void show();

    private static void setVisible(GamePanelEnum gamePanelEnum) {
        for (GamePanelEnum value : GamePanelEnum.values()) {
            value.getPanel().setVisible(value == gamePanelEnum);
        }

    }

}
