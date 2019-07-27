package com.noile.SeaBattle.Logic;

import com.noile.SeaBattle.Logic.Ships.Ships;
import com.noile.SeaBattle.View.CellPane;

import java.awt.*;
import java.util.ArrayList;

public class Field {
    ArrayList<Cell> field;
    ArrayList<CellPane> fieldPanel;

    public Field(ArrayList fieldPanel) {

        field = new ArrayList<>();
        this.fieldPanel = new ArrayList();
        this.fieldPanel = fieldPanel;

        for (int i = 0; i < 100; i++) {
            field.add(new Cell());
        }
        System.out.println(field.size());

    }

    public void takeShipAxisY(int numberField, Ships classShips,int size) {
        field.get(numberField).setClassShip(classShips);

        if (size == 2 || size == 3 || size == 4) {
            field.get(numberField + 10).setClassShip(classShips);
            if (size == 3 || size == 4) {
                field.get(numberField + 20).setClassShip(classShips);
                if (size == 4) {
                    field.get(numberField + 30).setClassShip(classShips);
                }
            }
        }
    }

    public void takeShipAxisX(int numberField, Ships classShips,int size) {
        field.get(numberField).setClassShip(classShips);
        fieldPanel.get(numberField).setBackground(Color.GREEN);
        if (size == 2 || size == 3 || size == 4) {
            field.get(numberField + 1).setClassShip(classShips);
            fieldPanel.get(numberField + 1).setBackground(Color.GREEN);
            if (size == 3 || size == 4) {
                field.get(numberField + 2).setClassShip(classShips);
                fieldPanel.get(numberField + 2).setBackground(Color.GREEN);
                if (size == 4) {
                    field.get(numberField + 3).setClassShip(classShips);
                    fieldPanel.get(numberField + 3).setBackground(Color.GREEN);
                }
            }
        }

        for (Cell i : field) {
            if(i.getClassShip() != null) {
                System.out.println(i.getClassShip());
            }
        }
        System.out.println("----------------------------------------------------");
    }
}
