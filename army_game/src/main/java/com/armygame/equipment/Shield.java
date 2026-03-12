package com.armygame.equipment;

import java.lang.reflect.Constructor;

import com.armygame.soldier.Soldier;
import com.armygame.visitor.ArmyVisitor;

public class Shield extends SoldierDecorator {
    private final int defense = 10;

    Shield(Soldier source) {
        super(source);
    }

    @Override
    public boolean wardOff(int strength) {
        return super.wardOff(Math.max(strength - this.defense, 0));
    }
    @Override
    public void accept(ArmyVisitor visitor) {
      
        super.accept(visitor);
        visitor.visit(this); 
    }
 
}
