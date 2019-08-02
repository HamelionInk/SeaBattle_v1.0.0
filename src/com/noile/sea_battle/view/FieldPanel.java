package com.noile.sea_battle.view;


import com.noile.sea_battle.logic.PutShip;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class FieldPanel extends JPanel {

    int position = -1;

    public FieldPanel(ArrayList<CellPane> fieldPanelList, PutShip test) {

        GridBagConstraints gbc = new GridBagConstraints();

        setLayout(new GridBagLayout());

            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane(test, position = position + 1);
                    fieldPanelList.add(cellPane);

                    Border border = null;
                    if (row < 9) {
                        if (col < 9) {
                            border = new MatteBorder(1, 1, 0, 0, Color.black);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.black);
                        }
                    } else {
                        if (col < 9) {
                            border = new MatteBorder(1, 1, 1, 0, Color.black);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.black);
                        }
                    }
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                }
            }
        }

        public void putSship() {
        
        }
    }

