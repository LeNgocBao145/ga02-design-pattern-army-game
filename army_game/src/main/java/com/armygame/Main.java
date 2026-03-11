package com.armygame;

import com.armygame.equipment.Shield;
import com.armygame.equipment.Sword;
import com.armygame.soldier.Horseman;
import com.armygame.soldier.Infantryman;
import com.armygame.soldier.Soldier;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Army Game - Decorator Pattern Demo ===\n");

        // --- Test Infantryman (no equipment) ---
        System.out.println("--- Infantryman (no equipment) ---");
        Soldier infantryman = new Infantryman();
        int dmg1 = infantryman.hit();
        System.out.println("Damage dealt: " + dmg1);
        boolean survived1 = infantryman.wardOff(150);
        System.out.println("Survived attack: " + survived1);

        System.out.println();

        // --- Test Horseman (no equipment) ---
        System.out.println("--- Horseman (no equipment) ---");
        Soldier horseman = new Horseman();
        int dmg2 = horseman.hit();
        System.out.println("Damage dealt: " + dmg2);
        boolean survived2 = horseman.wardOff(50);
        System.out.println("Survived attack: " + survived2);

        System.out.println();

        // --- Test Infantryman with Sword ---
        System.out.println("--- Infantryman + Sword ---");
        Soldier infantrymanWithSword = new Sword(new Infantryman());
        int dmg3 = infantrymanWithSword.hit();
        System.out.println("Damage dealt (with Sword bonus): " + dmg3);

        System.out.println();

        // --- Test Infantryman with Shield ---
        System.out.println("--- Infantryman + Shield ---");
        Soldier infantrymanWithShield = new Shield(new Infantryman());
        boolean survived3 = infantrymanWithShield.wardOff(15);
        System.out.println("Survived attack (with Shield reduction): " + survived3);

        System.out.println();

        // --- Test Horseman with Sword + Shield (stacked decorators) ---
        System.out.println("--- Horseman + Sword + Shield (stacked) ---");
        Soldier fullyEquippedHorseman = new Shield(new Sword(new Horseman()));
        int dmg4 = fullyEquippedHorseman.hit();
        System.out.println("Damage dealt (with Sword bonus): " + dmg4);
        boolean survived4 = fullyEquippedHorseman.wardOff(20);
        System.out.println("Survived attack (with Shield reduction): " + survived4);

        System.out.println();

        // --- Battle simulation: Infantryman vs Horseman ---
        System.out.println("--- Battle: Infantryman (Sword+Shield) vs Horseman ---");
        Soldier attacker = new Sword(new Shield(new Infantryman()));
        Soldier defender = new Horseman();

        int attackStrength = attacker.hit();
        System.out.println("Attacker deals: " + attackStrength);
        boolean defenderSurvived = defender.wardOff(attackStrength);
        System.out.println("Defender survived: " + defenderSurvived);
    }
}
