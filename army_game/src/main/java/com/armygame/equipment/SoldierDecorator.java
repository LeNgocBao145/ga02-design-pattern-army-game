package com.armygame.equipment;

import com.armygame.soldier.Soldier;

public abstract class SoldierDecorator implements Soldier {
    private final Soldier wrappee;

    public SoldierDecorator(Soldier source) {
        this.wrappee = source;
    }

    @Override
    public int hit() {
        return wrappee.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return wrappee.wardOff(strength);
    }
}
