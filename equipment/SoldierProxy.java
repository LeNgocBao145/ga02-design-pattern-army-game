package equipment;

import soldier.Soldier;
import visitor.ArmyVisitor;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class SoldierProxy implements Soldier {
    private Soldier soldier;
    private final Set<Class<? extends SoldierDecorator>> equipments = new HashSet<>();
     private  Set<Class<? extends SoldierDecorator>> validEquipments;

    public SoldierProxy(Soldier soldier) {
        this.soldier = soldier;
    }

    public SoldierProxy(Soldier soldier, Set<Class<? extends SoldierDecorator>> validEquipments) {
        this.soldier = soldier;
        this.validEquipments = validEquipments;
    }
    @Override
    public float hit() {
        return soldier.hit();
    }

    @Override
    public boolean wardOff(float strength) {
        return soldier.wardOff(strength);
    }
    
    @Override
    public void addEquipment(Class<? extends SoldierDecorator> type) {
        if (!validEquipments.contains(type)){
            System.out.println("Equipment " + type.getSimpleName() + " is not allow");
            return;
        }
        if(equipments.contains(type)) {
            System.out.println("Equipment already added: " + type.getSimpleName());
            return;
        }
        if(!equipments.contains(type)) {

            try {

                Constructor<? extends SoldierDecorator> ctor =
                        type.getDeclaredConstructor(Soldier.class);

                soldier = ctor.newInstance(soldier);

                equipments.add(type);

            } catch (Exception e) {
                throw new IllegalStateException("Failed to add equipment: " + type.getName(), e);
            }
        }
    }
    @Override
    public String getName(){
        return soldier.getName();
    }
    @Override
public void accept(ArmyVisitor visitor) {
   
    visitor.visit(this); 
    if (soldier != null) {
        soldier.accept(visitor); 
    }
    System.out.println(); 
}
}
