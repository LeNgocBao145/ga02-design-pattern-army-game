package com.armygame.visitor;

import com.armygame.army.Group;
import com.armygame.equipment.Shield;
import com.armygame.equipment.SoldierProxy;
import com.armygame.equipment.Sword;
import com.armygame.soldier.Horseman;
import com.armygame.soldier.Infantryman;


public interface ArmyVisitor {
    default void visit(Group group) {}
    default void visit(SoldierProxy proxy) {}
    default void visit(Infantryman infantryman) {}
    default void visit(Horseman horseman) {}
    default void visit(Sword sword) {}
    default void visit(Shield shield) {}
}
