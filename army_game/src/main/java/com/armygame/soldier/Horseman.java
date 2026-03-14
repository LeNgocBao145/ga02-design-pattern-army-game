package com.armygame.soldier;

public class Horseman extends BaseSoldier{
    public Horseman() {
        super(150.0f, 15);
    }

    public float hit(){
        System.out.println("Horseman hit with strength " + this.strength);
        return (float) this.strength;
    }

    public boolean wardOff(float strength){
        System.out.println("Horseman ward off with strength " + strength);
        if(this.hp <= 0) return false;
        setHp(Math.max(this.hp - strength, 0.0f));
        return this.hp > 0;
    }
}
