package visitor;
import army.Group;
import equipment.Shield;
import equipment.SoldierProxy;
import equipment.Sword;
import equipment.Armor;
import equipment.Spear;
import equipment.Armor;
import equipment.BiologicalWeapon;
import equipment.Grenade;
import equipment.Helmet;
import equipment.LaserSword;
import equipment.NanoArmor;
import equipment.Rifle;
import soldier.Horseman;
import soldier.Infantryman;

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
  
    @Override
    public void visit(Spear spear) {
       
        System.out.print("[Spear] ");
    }
    @Override
    public void visit(Armor armor) {
       
        System.out.print("[Armor] ");
    }
    @Override
    public void visit(BiologicalWeapon BiologicalWeapon) {
       
        System.out.print("[BiologicalWeapon] ");
    }
    @Override
    public void visit(Grenade Grenade) {
       
        System.out.print("[Grenade] ");
    }
    @Override
    public void visit(Helmet Helmet) {
       
        System.out.print("[Helmet] ");
    }
    @Override
    public void visit(LaserSword LaserSword) {
       
        System.out.print("[LaserSword] ");
    }
    @Override
    public void visit(NanoArmor NanoArmor) {
       
        System.out.print("[NanoArmor] ");
    }
    @Override
    public void visit(Rifle Rifle) {
       
        System.out.print("[Rifle] ");
    }
}
