package com.armygame.equipment;

import com.armygame.soldier.Soldier;

public class Shield extends SoldierDecorator {
    private final int defense = 10;

    Shield(Soldier source) {
        super(source);
    }

    @Override
    public boolean wardOff(int strength) {
        return super.wardOff(Math.max(strength - this.defense, 0));
    }
}
