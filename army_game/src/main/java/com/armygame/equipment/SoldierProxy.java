package com.armygame.equipment;

import com.armygame.soldier.Soldier;

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

    public void addEquipment(Class<? extends SoldierDecorator> type) {

        if(!equipments.contains(type)) {

            try {

                Constructor<? extends SoldierDecorator> ctor =
                        type.getConstructor(Soldier.class);

                soldier = (Soldier) ctor.newInstance(soldier);

                equipments.add(type);

            } catch (Exception e) {
                throw new IllegalStateException("Failed to add equipment: " + type.getName(), e);
            }
        }
    }
}
