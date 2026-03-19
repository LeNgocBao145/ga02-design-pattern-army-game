package equipment;

import soldier.Soldier;
import visitor.ArmyVisitor;

public class Spear extends SoldierDecorator {
    private final int damage = 20;
    private static final int durability = 4;
    

    Spear(Soldier source) {
        super(source, durability);
    }

    @Override
    public float hit() {
        
        float currentDamage = damage * ((float) currentDurability / durability);
        this.decreaseCurrentDurability();
        return super.hit() + currentDamage;
    }
    @Override
    public void accept(ArmyVisitor visitor) {
        
        super.accept(visitor); 
        visitor.visit(this); 
    }
}
