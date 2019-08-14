package com.noile.sea_battle.view.button;

import com.noile.sea_battle.logic.game_process.EnumGameStage;
import com.noile.sea_battle.logic.game_process.Game;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StageButton extends JButton {

    public StageButton(Game game) {
        super("Start Battle");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.setGameStage(EnumGameStage.BATTLE_STAGE);
            }
        });
    }
}
