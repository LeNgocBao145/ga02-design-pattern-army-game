package com.armygame.equipment;

import com.armygame.soldier.Soldier;

public class Sword extends SoldierDecorator {
    private final int damage = 10;

    Sword(Soldier source) {
        super(source, 3);
    }

    @Override
    public float hit() {
        decreaseCurrentDurability();
        float currentDamage = damage * ((float) currentDurability / durability);

        return super.hit() + currentDamage;
    }
}
