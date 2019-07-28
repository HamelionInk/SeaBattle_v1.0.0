package com.noile.SeaBattle.View;

import com.noile.SeaBattle.Logic.TakeShip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CellPane extends JPanel {

        private Color defaultBackground;

        public CellPane(int index, TakeShip takeShip, ArrayList<CellPane> fieldPanelList) {

            defaultBackground = getBackground();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (takeShip.getStatus() == true) {
                        takeShip.setNumberField(index);
                        takeShip.takeShip();
                        takeShip.setClassShip(null);
                        takeShip.setStatus(false);
                        defaultBackground = getBackground();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (takeShip.getStatus()) {
                        fieldPanelList.get(index).defaultBackground = getBackground();
                        fieldPanelList.get(index).setBackground(Color.ORANGE);
                        if (takeShip.getSize() == 2 || takeShip.getSize() == 3 || takeShip.getSize() == 4) {
                            fieldPanelList.get(index + 1).defaultBackground = getBackground();
                            fieldPanelList.get(index + 1).setBackground(Color.ORANGE);
                            if (takeShip.getSize() == 3 || takeShip.getSize() == 4) {
                                fieldPanelList.get(index + 2).defaultBackground = getBackground();
                                fieldPanelList.get(index + 2).setBackground(Color.ORANGE);
                                if (takeShip.getSize() == 4) {
                                    fieldPanelList.get(index + 3).defaultBackground = getBackground();
                                    fieldPanelList.get(index + 3).setBackground(Color.ORANGE);
                                }
                            }
                        }
                    } else {
                        fieldPanelList.get(index).defaultBackground = getBackground();
                        fieldPanelList.get(index).setBackground(Color.WHITE);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {

                    if (takeShip.getStatus()) {
                        fieldPanelList.get(index).setBackground(defaultBackground);
                        if (takeShip.getSize() == 2 || takeShip.getSize() == 3 || takeShip.getSize() == 4) {
                            fieldPanelList.get(index + 1).setBackground(defaultBackground);
                            if (takeShip.getSize() == 3 || takeShip.getSize() == 4) {
                                fieldPanelList.get(index + 2).setBackground(defaultBackground);
                                if (takeShip.getSize() == 4) {
                                    fieldPanelList.get(index + 3).setBackground(defaultBackground);
                                }
                            }
                        }
                    } else {
                        fieldPanelList.get(index).setBackground(defaultBackground);
                    }
                }

            });
        }

    @Override
        public Dimension getPreferredSize() {
            return new Dimension(25, 25);
        }
    }




