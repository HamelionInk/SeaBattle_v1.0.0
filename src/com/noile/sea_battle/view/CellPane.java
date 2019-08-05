package com.noile.sea_battle.view;

import com.noile.sea_battle.logic.Cell;
import com.noile.sea_battle.logic.PutShip;
import com.noile.sea_battle.logic.ships.Ships;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CellPane extends JPanel {

    JLabel viewShip = new JLabel();

    Cell cell = new Cell();

    private int position;
    private Color defaultBackground;
    private PutShip putShip;

    public CellPane(PutShip putShip, int position) {
        this.putShip = putShip;
        this.position = position;

        setLayout(new GridBagLayout());
        viewShip.setOpaque(true);

        add(viewShip);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                putShip.setPosition(getPosition());
                putShip.putShip();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                putShip.setPosition(getPosition());
                putShip.entered();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                putShip.setPosition(getPosition());
                putShip.exited();
            }
        });
    }

    public void setShipViewIcon() {
        viewShip.setIcon(cell.getShipImage());
    }

    public void reloadStateCell() {
        cell.state();
    }

    public void setCellClassShip() {
        cell.setClassShip(putShip.getClassShips());
    }

    public Ships getCellClassShip() {
        return cell.getClassShip();
    }

    public int getPosition() {
        return position;
    }

    public void setDefaultBackground() {
        this.defaultBackground = getBackground();
    }

    public void getDefaultBackground() {
        setBackground(defaultBackground);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(25, 25);
    }

}




