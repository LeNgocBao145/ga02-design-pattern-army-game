package com.armygame.equipment;

import com.armygame.soldier.Soldier;

public class Sword extends SoldierDecorator implements Equipment{
    private final int damage = 10;

    public Sword(Soldier source) {
        super(source);
    }

    @Override
    public int hit() {
        return super.hit() + this.damage;
    }

    @Override
    public Soldier applyEquipment(Soldier soldier) {
        return new Sword(soldier);
    }
}
