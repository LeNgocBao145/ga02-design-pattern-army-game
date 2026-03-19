package equipment;

import java.lang.reflect.Constructor;

import soldier.Soldier;
import visitor.ArmyVisitor;

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

    @Override
    public void addEquipment(Class<? extends SoldierDecorator> type) {

        wrappee.addEquipment(type);
    }
    public void decreaseCurrentDurability() {
        if(currentDurability > 0) {
            currentDurability--;
        }
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
