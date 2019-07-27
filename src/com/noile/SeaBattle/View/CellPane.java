package com.noile.SeaBattle.View;

import com.noile.SeaBattle.Logic.TakeShip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

    public class CellPane extends JPanel {

        private Color defaultBackground;
        private int aIndex;

        public CellPane(int index, TakeShip takeShip) {
            this.aIndex = index;

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (takeShip.getStatus() == true) {
                        takeShip.setNumberField(aIndex);
                        takeShip.takeShip();
                        takeShip.setClassShip(null);
                        takeShip.setStatus(false);
                        defaultBackground = getBackground();
                    } else {
                        setBackground(defaultBackground);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.BLUE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(25, 25);
        }

        public int getaIndex() {
            return aIndex;
        }
    }




