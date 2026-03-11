package com.armygame;

import com.armygame.equipment.Shield;
import com.armygame.equipment.SoldierProxy;
import com.armygame.equipment.Sword;
import com.armygame.soldier.Horseman;
import com.armygame.soldier.Infantryman;
import com.armygame.soldier.Soldier;

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
    }
}
