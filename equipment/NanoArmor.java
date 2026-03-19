package equipment;

import java.lang.reflect.Constructor;

import soldier.Soldier;
import visitor.ArmyVisitor;

public class NanoArmor extends SoldierDecorator {
     private final int defense = 35;
     private static final int durability = 5;

    NanoArmor(Soldier source) {
        super(source, durability);
    }

    @Override
   public boolean wardOff(float strength) {
        this.decreaseCurrentDurability();
        float currentDefence = defense * ((float) currentDurability / durability);
        return super.wardOff(Math.max(strength - currentDefence, 0.0f));
    }
    @Override
    public void accept(ArmyVisitor visitor) {
      
        super.accept(visitor);
        visitor.visit(this); 
    }
 
}
