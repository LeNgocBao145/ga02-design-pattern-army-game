package com.armygame.equipment;

import com.armygame.soldier.Soldier;
import com.armygame.visitor.ArmyVisitor;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class SoldierProxy implements Soldier {
    private Soldier soldier;
    private final Set<Class<? extends SoldierDecorator>> equipments = new HashSet<>();

    public SoldierProxy(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public int hit() {
        return soldier.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return soldier.wardOff(strength);
    }
    
    @Override
    public void addEquipment(Class<? extends SoldierDecorator> type) {

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
