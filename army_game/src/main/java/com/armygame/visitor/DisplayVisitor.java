package com.armygame.visitor;
import com.armygame.army.Group;
import com.armygame.equipment.Shield;
import com.armygame.equipment.SoldierProxy;
import com.armygame.equipment.Sword;
import com.armygame.soldier.Horseman;
import com.armygame.soldier.Infantryman;

public class DisplayVisitor implements ArmyVisitor {

    public void visit(Group group) {
        System.out.println("\n=== List of ARMY ===");
    }

    @Override
    public void visit(SoldierProxy proxy) {
        
        System.out.print("- Name: " + proxy.getName() + " | ");
    }

    @Override
    public void visit(Infantryman infantryman) {
        
        System.out.print("Type: Infantryman | Equipment: ");
    }

    @Override
    public void visit(Horseman horseman) {
        System.out.print("Type: Horseman | Equipment: ");
    }

    @Override
    public void visit(Sword sword) {
    
        System.out.print("[Sword] ");
    }

    @Override
    public void visit(Shield shield) {
       
        System.out.print("[Shield] ");
    }
}
