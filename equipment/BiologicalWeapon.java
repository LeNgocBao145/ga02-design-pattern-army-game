package equipment;

import soldier.Soldier;
import visitor.ArmyVisitor;

public class BiologicalWeapon extends SoldierDecorator {
    private final int damage = 25;
    private static final int durability = 5;
    

 BiologicalWeapon (Soldier source) {
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
