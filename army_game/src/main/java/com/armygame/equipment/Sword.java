package com.armygame.equipment;

import com.armygame.soldier.Soldier;
import com.armygame.visitor.ArmyVisitor;

public class Sword extends SoldierDecorator {
    private final int damage = 10;

    Sword(Soldier source) {
        super(source);
    }

    @Override
    public int hit() {
        return super.hit() + this.damage;
    }
    @Override
    public void accept(ArmyVisitor visitor) {
        
        super.accept(visitor); 
        visitor.visit(this); 
    }
}
