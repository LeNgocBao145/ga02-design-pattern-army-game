package soldier;

import equipment.SoldierDecorator;
import visitor.ArmyVisitor;

public class Horseman extends BaseSoldier{
    public Horseman() {
        super(150, 15, "Horseman");
    }
    public Horseman(String name) {
        super(150, 15, name);
    }
    public Horseman(float hp, float strength, String name) {
            super(hp, strength, name);
    }
    public float hit(){
        System.out.println("Horseman hit with strength " + this.strength);
        return this.strength;
    }

    public boolean wardOff(float strength){
        System.out.println("Horseman ward off with strength " + strength);
         if (strength <= 0) {
            System.out.print("\nMau con lai: " + this.hp);
            return true;
        }
        boolean isLive = true;
        if (this.hp > strength){
         setHp(this.hp - strength);
           isLive = true; 
        }
        else {
            setHp(0);
            isLive = false;
        }
        if (isLive == false){
            this.notifyObservers();

        }
     
        return isLive;
    }
    //Chỉ để trống 
    public void addEquipment(Class <? extends SoldierDecorator> type){}
    @Override
    public void accept(ArmyVisitor visitor) {
        visitor.visit(this);
    }

}
