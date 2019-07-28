package com.noile.SeaBattle.View;

import com.noile.SeaBattle.Logic.TakeShip;


import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class FieldPanel extends JPanel {


    private int index;

    public FieldPanel(TakeShip takeShip, ArrayList<CellPane> fieldPanelList) {
            index = -1;

        GridBagConstraints gbc = new GridBagConstraints();

        setLayout(new GridBagLayout());

            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane(index += 1, takeShip, fieldPanelList);
                    fieldPanelList.add(cellPane);

                    Border border = null;
                    if (row < 9) {
                        if (col < 9) {
                            border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                        }
                    } else {
                        if (col < 9) {
                            border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                        }
                    }
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                }
            }
        }
    }

