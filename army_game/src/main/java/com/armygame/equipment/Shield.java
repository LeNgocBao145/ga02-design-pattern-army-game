package com.armygame.equipment;

import com.armygame.soldier.Soldier;

public class Shield extends SoldierDecorator implements Equipment{
    private final int defense = 10;

    public Shield(Soldier source) {
        super(source);
    }

    @Override
    public boolean wardOff(int strength) {
        return super.wardOff(strength - this.defense);
    }

    @Override
    public Soldier applyEquipment(Soldier soldier) {
        return new Shield(soldier);
    }
}
