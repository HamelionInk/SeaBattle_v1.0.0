package com.noile.SeaBattle.View;

import javax.swing.*;

public enum SwitchEnum {

    MENU_PANEL {
        private MenuPanel menuPanel = new MenuPanel();

        JPanel getPanel() {
            return menuPanel;
        }

        void show() {
            setVisible(this);
        }
    },

    GAME_PANEL {
        private GamePanel gamePanel = new GamePanel();

        JPanel getPanel() {
            return gamePanel;
        }

        void show() {
            setVisible(this);
        }
    },

    OPTIONS_PANEL {
        private OptionsPanel optionsPanel = new OptionsPanel();

        JPanel getPanel() {
            return optionsPanel;
        }

        void show() {
            setVisible(this);
        }
    },

    RECORDS_PANEL {
        private RecordsPanel recordsPanel = new RecordsPanel();

        JPanel getPanel() {
            return recordsPanel;
        }

        void show() {
            setVisible(this);
        }
    };

    abstract JPanel getPanel();

    abstract void show();

    private static void setVisible(SwitchEnum switchEnum) {
        for (SwitchEnum value : SwitchEnum.values()) {
            value.getPanel().setVisible(value == switchEnum);
        }
    }
}
