package com.armygame.soldier;

public abstract class BaseSoldier implements Soldier {
    protected int hp;
    protected int strength;

    BaseSoldier(int hp, int strength) {
        this.hp = hp;
        this.strength = strength;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
