package org.example;

public class Sword extends SoldierDecorator{
    private final int damage = 10;

    public Sword(Soldier source) {
        super(source);
    }

    @Override
    public int hit() {
        return super.hit() + this.damage;
    }
}
