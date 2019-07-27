package com.noile.SeaBattle.Logic;

import com.noile.SeaBattle.Logic.Ships.Ships;

public class Cell {
    boolean hit = false;

    Ships classShip;

    public Cell() {
    }

    public void setHit() {
        hit = true;
        if(hit) {
            classShip.takeDamage();
            System.out.println(classShip.getHealPoints());
            System.out.println(hit);
        }
    }

    public void setClassShip(Ships classShip) {
        this.classShip = classShip;
    }

    public Ships getClassShip() {
        return classShip;
    }
}

// Поместить сылку на один объект
