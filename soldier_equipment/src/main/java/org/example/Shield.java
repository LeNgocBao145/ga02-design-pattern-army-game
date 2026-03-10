package org.example;

public class Shield extends SoldierDecorator{
    private final int defense = 10;

    public Shield(Soldier source) {
        super(source);
    }

    @Override
    public boolean wardOff(int strength) {
        return super.wardOff(strength - this.defense);
    }
}
