package com.noile.SeaBattle.Logic.Ships;

public class Boat extends Ships {
    int amountBoat = 4;

    public Boat() {
        setHealPoints(1);
        setAmount(amountBoat - 1);
        setName("BoatView");
    }

}
