package com.armygame.soldier;

public abstract class BaseSoldier implements Soldier {
    protected float hp;
    protected int strength;

    BaseSoldier(float hp, int strength) {
        this.hp = hp;
        this.strength = strength;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }
}
