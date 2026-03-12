package com.armygame.army;

import com.armygame.equipment.SoldierDecorator;
import com.armygame.visitor.ArmyVisitor;

public interface ArmyComponent {
    public int hit();
    public boolean wardOff(int strength);
    public void addEquipment(Class<? extends SoldierDecorator> type);
    public String getName();
    public void accept(ArmyVisitor visitor);
}
