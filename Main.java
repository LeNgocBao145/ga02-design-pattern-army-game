
import army.Group;
import equipment.Shield;
import equipment.SoldierProxy;
import equipment.Sword;
import equipment.BiologicalWeapon;
import equipment.Grenade;
import equipment.Helmet;
import equipment.LaserSword;
import equipment.NanoArmor;
import equipment.Rifle;
import equipment.Spear;
import equipment.Armor;
import soldier.Horseman;
import soldier.Infantryman;
import soldier.Soldier;
import visitor.CountVisitor;
import visitor.DisplayVisitor;
import factory.GenerationFactory;
import factory.Medieval;
import factory.ScienceFiction;
import factory.WorldWar;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Army Game - Decorator Pattern Demo ===\n");

           System.out.println("=========== PART 1 : EQUIPMENT SYSTEM ===========");
        System.out.println("Design Patterns: Decorator + Proxy\n");

        // ===== 1. Create soldiers via Abstract Factory =====
        GenerationFactory medieval = new Medieval();

        SoldierProxy inf = medieval.createInfantryman("Luan");
        SoldierProxy cav = medieval.createHorseman("Bao");

        // ===== 2. Decorator via Proxy =====
        System.out.println("---- Equip Infantryman with Sword + Shield ----");
        inf.addEquipment(Sword.class);
        inf.addEquipment(Armor.class);

        System.out.println("Infantryman hit(): " + inf.hit());
        System.out.println("Infantryman wardOff(30): " + inf.wardOff(30));

        // ===== 3. Proxy prevents duplicate equipment =====
        System.out.println("\n---- Try duplicate equipment ----");
        inf.addEquipment(Sword.class); // should be ignored

        // ===== 4. Equipment durability (transparent) =====
        System.out.println("\n---- Equipment durability demo ----");
        System.out.println("Infantryman hit() decrease 1: " + inf.hit());
        System.out.println("Infantryman hit() decrease 2: " + inf.hit());
        inf.wardOff(100);


        System.out.println("\n=========== PART 2 — ARMY ORGANIZATION ===========");
        System.out.println("Design Patterns: Composite + Visitor\n");

        // ===== 5. Composite: Build Army =====
        Group squad1 = new Group();
        squad1.add(inf);
        squad1.add(cav);

        SoldierProxy inf2 = medieval.createInfantryman("Tri");
        inf2.addEquipment(Armor.class);

        Group squad2 = new Group();
        squad2.add(inf2);

        Group army = new Group();
        army.add(squad1);
        army.add(squad2);

        // ===== 6. Composite behaviors =====
        System.out.println("Army total hit(): " + army.hit());
        System.out.println("Army wardOff(60): " + army.wardOff(60));

        System.out.println("\nEquip whole army with Sword:");
        army.addEquipment(Sword.class);
        System.out.println("Army total hit(): " + army.hit());

        // ===== 7. Visitor: Display =====
        System.out.println("\n---- DisplayVisitor ----");
        DisplayVisitor display = new DisplayVisitor();
        army.accept(display);

        // ===== 8. Visitor: Count =====
        System.out.println("\n---- CountVisitor ----");
        CountVisitor counter = new CountVisitor();
        army.accept(counter);
        counter.showReport();


        System.out.println("\n=========== PART 3 — BATTLE MONITORING ===========");
        System.out.println("Design Patterns: Observer + Singleton + Abstract Factory\n");
        inf.wardOff(1000);
        cav.wardOff(1000);

        GenerationFactory scienceFiction = new ScienceFiction();
        SoldierProxy inf3 = scienceFiction.createInfantryman();
        inf3.addEquipment(Sword.class);
        inf3.addEquipment(LaserSword.class);
         System.out.println("Infantryman total hit(): " + inf3.hit());
      

        System.out.println("\n=========== DEMO COMPLETE ===========");
    }
}
