package com.armygame.equipment;

import com.armygame.soldier.Soldier;

public abstract class SoldierDecorator implements Soldier {
    private final Soldier wrappee;
    protected int durability;
    protected int currentDurability;

    public SoldierDecorator(Soldier source) {
        this.durability = 5;
        this.currentDurability = 5;
        this.wrappee = source;
    }

    public SoldierDecorator(Soldier source, int durability) {
        this.durability = durability;
        this.currentDurability = durability;
        this.wrappee = source;
    }

    @Override
    public float hit() {
        return wrappee.hit();
    }

    @Override
    public boolean wardOff(float strength) {
        return wrappee.wardOff(strength);
    }

    public void decreaseCurrentDurability() {
        if(currentDurability > 0) {
            currentDurability--;
        }
    }

    public int getCurrentDurability() {
        return currentDurability;
    }
}
