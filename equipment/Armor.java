package equipment;

import java.lang.reflect.Constructor;

import soldier.Soldier;
import visitor.ArmyVisitor;

public class Armor extends SoldierDecorator {
     private final int defense = 20;
     private static final int durability = 5;

    Armor(Soldier source) {
        super(source, durability);
    }

    @Override
   public boolean wardOff(float strength) {
        float currentDefence = defense * ((float) currentDurability / durability);
        this.decreaseCurrentDurability();
        return super.wardOff(Math.max(strength - currentDefence, 0.0f));
    }
    @Override
    public void accept(ArmyVisitor visitor) {
      
        super.accept(visitor);
        visitor.visit(this); 
    }
 
}
