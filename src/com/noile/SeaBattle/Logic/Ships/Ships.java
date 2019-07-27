package com.noile.SeaBattle.Logic.Ships;

public abstract class Ships {
    private int healPoints;
    private int amount;
    private String name;

    public void takeDamage(){
            healPoints = healPoints - 1;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
