package com.armygame.soldier;

import com.armygame.equipment.SoldierDecorator;
import com.armygame.visitor.ArmyVisitor;

public class Infantryman extends BaseSoldier{
    public Infantryman() {
        super(100, 10,"Infrantryman");
    }
    public Infantryman(int hp, int strength, String name) {
        super(hp, strength, name);
    }
    public int hit(){
        System.out.println("Infantryman hit with strength " + this.strength);
        return this.strength;
    }
    public boolean wardOff(int strength){
        System.out.println("Infantryman ward off with strength " + strength);
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
