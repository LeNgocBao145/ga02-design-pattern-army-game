package com.armygame.soldier;

public class Infantryman extends BaseSoldier{
    public Infantryman() {
        super(100, 10);
    }

    public int hit(){
        System.out.println("Infantryman hit with strength " + this.strength);
        return this.strength;
    }
    public boolean wardOff(int strength){
        System.out.println("Infantryman ward off with strength " + strength);
        setHp(this.hp - strength);
        return strength < this.hp;
    }
}
