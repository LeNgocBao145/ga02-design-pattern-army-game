package com.armygame.soldier;

import com.armygame.equipment.SoldierDecorator;
import com.armygame.visitor.ArmyVisitor;

public class Horseman extends BaseSoldier{
    public Horseman() {
        super(150, 15, "Horseman");
    }
    public Horseman(int hp, int strength, String name) {
            super(hp, strength, name);
    }
    public int hit(){
        System.out.println("Horseman hit with strength " + this.strength);
        return this.strength;
    }

    public boolean wardOff(int strength){
        System.out.println("Horseman ward off with strength " + strength);
        setHp(this.hp - strength);
        return this.hp > 0;
    }
    //Chỉ để trống 
    public void addEquipment(Class <? extends SoldierDecorator> type){}
    @Override
    public void accept(ArmyVisitor visitor) {
        visitor.visit(this);
    }

}
