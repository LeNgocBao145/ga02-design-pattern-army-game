package visitor;

import army.Group;
import equipment.Shield;
import equipment.SoldierProxy;
import equipment.Sword;
import equipment.Armor;
import equipment.BiologicalWeapon;
import equipment.Grenade;
import equipment.Helmet;
import equipment.LaserSword;
import equipment.NanoArmor;
import equipment.Rifle;
import equipment.Spear;
import soldier.Horseman;
import soldier.Infantryman;


public interface ArmyVisitor {
    default void visit(Group group) {}
    default void visit(SoldierProxy proxy) {}
    default void visit(Infantryman infantryman) {}
    default void visit(Horseman horseman) {}
    default void visit(Sword sword) {}
    default void visit(Shield shield) {}
    default void visit(Armor armor) {}
    default void visit(Spear spear) {}
    default void visit(BiologicalWeapon biologicalWeapon) {}
    default void visit(Grenade grenade) {}
    default void visit(Helmet helmet) {}
    default void visit(LaserSword laserSword) {}
    default void visit(NanoArmor nanoArmor) {}
    default void visit(Rifle rifle) {}
}
