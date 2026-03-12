package com.armygame;

import com.armygame.army.Group;
import com.armygame.equipment.Shield;
import com.armygame.equipment.SoldierProxy;
import com.armygame.equipment.Sword;
import com.armygame.soldier.Horseman;
import com.armygame.soldier.Infantryman;
import com.armygame.soldier.Soldier;
import com.armygame.visitor.CountVisitor;
import com.armygame.visitor.DisplayVisitor;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Army Game - Decorator Pattern Demo ===\n");

        // ====== 1. Base soldiers without equipment ======
        System.out.println("--- 1. Infantryman (no equipment) ---");
        Soldier infantryman = new Infantryman();
        System.out.println("Hit damage: " + infantryman.hit());                 // expected: 10
        System.out.println("Survive wardOff(30): " + infantryman.wardOff(30));  // hp 100→70, true
        System.out.println("Survive wardOff(80): " + infantryman.wardOff(80));  // hp 70→-10, false
        System.out.println();

        System.out.println("--- 2. Horseman (no equipment) ---");
        Soldier horseman = new Horseman();
        System.out.println("Hit damage: " + horseman.hit());                    // expected: 15
        System.out.println("Survive wardOff(50): " + horseman.wardOff(50));     // hp 150→100, true
        System.out.println("Survive wardOff(120): " + horseman.wardOff(120));   // hp 100→-20, false
        System.out.println();

        // ====== 2. Equip via SoldierProxy — Sword (+10 damage) ======
        System.out.println("--- 3. Infantryman + Sword (via Proxy) ---");
        SoldierProxy swordInfantry = new SoldierProxy(new Infantryman());
        swordInfantry.addEquipment(Sword.class);
        System.out.println("Hit damage (10 base + 10 sword): " + swordInfantry.hit()); // expected: 20
        System.out.println();

        System.out.println("--- 4. Horseman + Sword (via Proxy) ---");
        SoldierProxy swordHorseman = new SoldierProxy(new Horseman());
        swordHorseman.addEquipment(Sword.class);
        System.out.println("Hit damage (15 base + 10 sword): " + swordHorseman.hit()); // expected: 25
        System.out.println();

        // ====== 3. Equip via SoldierProxy — Shield (reduce incoming by 10) ======
        System.out.println("--- 5. Infantryman + Shield (via Proxy) ---");
        SoldierProxy shieldInfantry = new SoldierProxy(new Infantryman());
        shieldInfantry.addEquipment(Shield.class);
        System.out.println("Survive wardOff(15) → effective 5: " + shieldInfantry.wardOff(15)); // true
        System.out.println("Survive wardOff(5)  → effective 0: " + shieldInfantry.wardOff(5));  // true
        System.out.println();

        // ====== 4. Stacked equipment (Sword + Shield) ======
        System.out.println("--- 6. Horseman + Sword + Shield (stacked via Proxy) ---");
        SoldierProxy fullyEquipped = new SoldierProxy(new Horseman());
        fullyEquipped.addEquipment(Sword.class);
        fullyEquipped.addEquipment(Shield.class);
        System.out.println("Hit damage (15 + 10 sword): " + fullyEquipped.hit());          // expected: 25
        System.out.println("Survive wardOff(20) → effective 10: " + fullyEquipped.wardOff(20)); // true
        System.out.println();

        // ====== 5. Proxy prevents duplicate equipment ======
        System.out.println("--- 7. Duplicate equipment prevention ---");
        SoldierProxy doubleSword = new SoldierProxy(new Infantryman());
        doubleSword.addEquipment(Sword.class);
        doubleSword.addEquipment(Sword.class); // should be ignored
        System.out.println("Hit after adding Sword twice (should still be 20): " + doubleSword.hit()); // expected: 20
        System.out.println();

        // ====== 6. Edge case: wardOff where strength == hp (soldier dies) ======
        System.out.println("--- 8. Edge case: wardOff(strength == hp) ---");
        Soldier edgeCase = new Infantryman();               // hp = 100
        edgeCase.wardOff(65);                                // hp = 35
        System.out.println("Survive wardOff(35) when hp=35: " + edgeCase.wardOff(35)); // hp=0 → false (dead)
        System.out.println();

        // ====== 7. Battle simulation ======
        System.out.println("--- 9. Battle: Infantryman(Sword+Shield) vs Horseman(Shield) ---");
        SoldierProxy attacker = new SoldierProxy(new Infantryman());
        attacker.addEquipment(Sword.class);
        attacker.addEquipment(Shield.class);

        SoldierProxy defender = new SoldierProxy(new Horseman());
        defender.addEquipment(Shield.class);

        int attackDmg = attacker.hit();
        System.out.println("Attacker (Infantryman+Sword+Shield) deals: " + attackDmg);     // 10+10 = 20
        boolean defSurvived = defender.wardOff(attackDmg);
        System.out.println("Defender (Horseman+Shield) survived: " + defSurvived);          // effective 10, true

        System.out.println();
        int counterDmg = defender.hit();
        System.out.println("Defender (Horseman+Shield) counter-attacks: " + counterDmg);    // 15
        boolean atkSurvived = attacker.wardOff(counterDmg);
        System.out.println("Attacker (Infantryman+Sword+Shield) survived: " + atkSurvived); // effective 5, true

        System.out.println("\n=== Demo Complete ===");


       System.out.println("\n\n=== Army Game - Composite & Visitor Pattern Demo ===\n");

        // ====== 1. Setup Composite Structure (Groups & Army) ======
        System.out.println("--- 1. Building the Army Structure ---");
        
        // Create Squad 1 (2 Infantrymen)
        Group squad1 = new Group();
        SoldierProxy inf1 = new SoldierProxy(new Infantryman(500,20,"Luan")); // HP: 100, Damage: 10
        SoldierProxy inf2 = new SoldierProxy(new Infantryman(300,50,"Tai")); // HP: 100, Damage: 10
        squad1.add(inf1);
        squad1.add(inf2);
        System.out.println("Created Squad 1 with 2 Infantrymen.");

        // Create Squad 2 (1 Horseman, 1 Infantryman already equipped with a Shield)
        Group squad2 = new Group();
        SoldierProxy horse1 = new SoldierProxy(new Horseman(250,30,"Thuy"));  // HP: 150, Damage: 15
        SoldierProxy inf3 = new SoldierProxy(new Infantryman(30,10,"Ngoc")); // HP: 100, Damage: 10
        inf3.addEquipment(Shield.class); // Equip in advance
        squad2.add(horse1);
        squad2.add(inf3);
        System.out.println("Created Squad 2 with 1 Horseman and 1 Infantryman (with Shield).");

        // Create the Army (Contains 2 Squads)
        Group army = new Group();
        army.add(squad1);
        army.add(squad2);
        System.out.println("Created Army containing Squad 1 and Squad 2.");
        System.out.println();

        // ====== 2. Composite: hit() (Aggregate Strength) ======
        System.out.println("--- 2. Composite hit() ---");
        // Expected total damage: (10 + 10) + (15 + 10) = 45
        System.out.println("Total Army Hit damage: " + army.hit() + " (Expected: 45)");
        System.out.println();

        // ====== 3. Composite: addEquipment() (Distribute to all) ======
        System.out.println("--- 3. Composite addEquipment() ---");
        System.out.println("Equipping the entire army with Swords...");
        army.addEquipment(Sword.class); 
        // Infantry 1, 2, 3 and Horseman 1 will all receive a Sword (+10 damage each)
        
        // New damage: 45 base + (4 units * 10 sword damage) = 85
        System.out.println("New Total Army Hit damage: " + army.hit() + " (Expected: 85)");
        System.out.println();

        // ====== 4. Visitor: DisplayVisitor ======
        System.out.println("--- 4. Visitor: DisplayVisitor ---");
        // Note: If your Proxy class has the 'name' attribute added,
        // the Visitor will print the names. Otherwise, it prints the basic structure.
        DisplayVisitor displayVisitor = new DisplayVisitor();
        army.accept(displayVisitor);
        System.out.println();

        // ====== 5. Visitor: CountVisitor ======
        System.out.println("--- 5. Visitor: CountVisitor ---");
        CountVisitor countVisitor = new CountVisitor();
        army.accept(countVisitor);
        countVisitor.showReport(); 
        // Expected: 3 Infantrymen, 1 Horseman
        System.out.println();

        // ====== 6. Composite: wardOff() (Damage Distribution & Casualties) ======
        System.out.println("--- 6. Composite wardOff() (Damage Distribution) ---");
        
        // Current structure: Army contains [Squad 1, Squad 2]. Total of 2 top-level units.
        // Attacking Army with 200 damage.
        
        
        System.out.println("Incoming massive attack of 200 damage to the Army!");
        boolean armySurvived = army.wardOff(200);
        System.out.println("Did the Army survive? " + armySurvived);
        
        System.out.println("\nChecking troops after attack (Running DisplayVisitor again):");
        army.accept(new DisplayVisitor());

        System.out.println("\n--- 7. Lethal Attack (Casualties simulation) ---");
      
       
        System.out.println("Incoming lethal attack of 400 damage!");
        army.wardOff(400);
        
        System.out.println("\nChecking remaining troops:");
        CountVisitor countRemaining = new CountVisitor(); // Count remaining alive units
        army.accept(countRemaining);
        countRemaining.showReport(); // Print the number of survivors
        
        System.out.println("\n=== Demo Part 2 Complete ===");
    }
}
