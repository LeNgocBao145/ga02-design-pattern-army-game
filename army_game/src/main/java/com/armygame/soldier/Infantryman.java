package com.armygame.soldier;

public class Infantryman extends BaseSoldier{
    public Infantryman() {
        super(100.0f, 10);
    }

    public float hit(){
        System.out.println("Infantryman hit with strength " + this.strength);
        return (float) this.strength;
    }
    public boolean wardOff(float strength){
        System.out.println("Infantryman ward off with strength " + strength);
        if(this.hp <= 0) return false;
        setHp(Math.max(this.hp - strength, 0.0f));
        return this.hp > 0;
    }
}
