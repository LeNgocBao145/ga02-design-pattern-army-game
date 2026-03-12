package com.armygame.soldier;

public abstract class BaseSoldier implements Soldier {
    protected int hp;
    protected int strength;
    protected String name;

    BaseSoldier(int hp, int strength, String name) {
        this.hp = hp;
        this.strength = strength;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public String getName(){
        return name;
    }
}
