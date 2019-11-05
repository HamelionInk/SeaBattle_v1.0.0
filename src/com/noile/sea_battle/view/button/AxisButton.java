package com.noile.sea_battle.view.button;

import com.noile.sea_battle.logic.game_process.EnumAxis;
import com.noile.sea_battle.logic.game_process.EnumGameStage;
import com.noile.sea_battle.logic.game_process.Game;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AxisButton extends JButton {

    public AxisButton(Game game) {
        super("Axis Button Test");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (game.getEnumAxis() == EnumAxis.AXIS_X) {
                    game.setEnumAxis(EnumAxis.AXIS_Y);
                    System.out.println("Y");
                } else {
                    if (game.getEnumAxis() == EnumAxis.AXIS_Y) {
                        game.setEnumAxis(EnumAxis.AXIS_X);
                        System.out.println("X");

                    }
                }
            }
        });
    }
}
