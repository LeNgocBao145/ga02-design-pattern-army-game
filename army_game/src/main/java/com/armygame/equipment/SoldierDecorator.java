package com.armygame.equipment;

import java.lang.reflect.Constructor;

import com.armygame.soldier.Soldier;
import com.armygame.visitor.ArmyVisitor;

public abstract class SoldierDecorator implements Soldier {
    private final Soldier wrappee;
    protected int durability;

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

    @Override
    public void addEquipment(Class<? extends SoldierDecorator> type) {

        wrappee.addEquipment(type);
    }
    public void decreaseDurability() {
        durability--;
    }

    public int getDurability() {
        return durability;
    }
    public String getName(){
        return wrappee.getName();
    }
    @Override
    public void accept(ArmyVisitor visitor) {
        wrappee.accept(visitor); 
    }
}
