package com.armygame.equipment;

import com.armygame.soldier.Soldier;

public class Shield extends SoldierDecorator {
    private final int defense = 10;

    Shield(Soldier source) {
        super(source, 5);
    }

    @Override
    public boolean wardOff(float strength) {
        decreaseCurrentDurability();
        float currentDefence = defense * ((float) currentDurability / durability);
        return super.wardOff(Math.max(strength - currentDefence, 0.0f));
    }
}
