package com.noile.sea_battle.logic.ships;

public abstract class Ships {
    private int healPoints;
    private int size;

    public void takeDamage(){
            healPoints = healPoints - 1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }
}
