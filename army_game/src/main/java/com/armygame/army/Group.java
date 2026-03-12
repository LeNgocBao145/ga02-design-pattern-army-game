package com.armygame.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.armygame.equipment.SoldierDecorator;
import com.armygame.visitor.ArmyVisitor;

public class Group implements ArmyComponent{
    
    List<ArmyComponent> components;
    public Group(){
        components = new ArrayList<>();
    }
    public int hit(){
        int sumStrength = 0;

        for (ArmyComponent armyComponent : components) {
            sumStrength = sumStrength + armyComponent.hit();
        }

        return sumStrength;
    }
    public boolean wardOff(int strength){


        if (components.isEmpty()) {
            return false; 
        }
        int dividedStrength = strength / components.size();

        Iterator<ArmyComponent> iterator = components.iterator();
        while (iterator.hasNext()) {
            ArmyComponent member = iterator.next();
            
            boolean isAlive = member.wardOff(dividedStrength); 
            if (!isAlive) {
                iterator.remove(); 
                System.out.println(" - A unit has fallen and was removed from the group!");
            }
        }
        return !components.isEmpty();
    }
    public void addEquipment(Class<? extends SoldierDecorator> type){
        for (ArmyComponent armyComponent : components) {
            armyComponent.addEquipment(type);
        }

    }

    public void add(ArmyComponent c) {
        if (c != null) {
            components.add(c);
        }
    }

    public void remove(ArmyComponent c) {
        if (c != null) {
            components.remove(c);
        }
    }
    public String getName(){
        return "";
    }
    public void accept(ArmyVisitor visitor){
        visitor.visit(this); 
    
    
        for (ArmyComponent c : components) {
            c.accept(visitor); 
        }
    }
}
