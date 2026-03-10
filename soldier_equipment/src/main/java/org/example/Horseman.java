package org.example;

public class Horseman extends BaseSoldier{
    public Horseman() {
        super(150, 15);
    }

    public int hit(){
        System.out.println("Horseman hit with strength " + this.strength);
        return this.strength;
    }

    public boolean wardOff(int strength){
        System.out.println("Horseman ward off with strength " + this.hp);
        setHp(this.hp - strength);
        return strength < this.hp;
    }
}
