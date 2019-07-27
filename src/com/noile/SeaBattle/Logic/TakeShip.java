package com.noile.SeaBattle.Logic;

import com.noile.SeaBattle.Logic.Ships.Ships;
import com.noile.SeaBattle.View.CellPane;

import java.util.ArrayList;

public class TakeShip {

    int numberField;
    int size;
    Ships classShip;
    boolean status = false;

    Field field;

    public TakeShip(ArrayList<CellPane> fieldPanel) {
        field = new Field(fieldPanel);
    }

    public void takeShip() {
        field.takeShipAxisX(numberField, classShip, size);
    }

    public void setNumberField(int numberField) {
        this.numberField = numberField;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setClassShip(Ships classShip) {
        this.classShip = classShip;
        status = true;
    }

    public Ships getClassShip() {
        return classShip;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
