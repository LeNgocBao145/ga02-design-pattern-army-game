package soldier;

import equipment.SoldierDecorator;
import visitor.ArmyVisitor;

public class Infantryman extends BaseSoldier{
    public Infantryman() {
        super(100, 10,"Infrantryman");
    }
    public Infantryman(float hp, float strength, String name) {
        super(hp, strength, name);
    }
     public Infantryman(String name) {
        super(100, 10, name);
    }
    public float hit(){
        System.out.println("Infantryman hit with strength " + this.strength);
        return this.strength;
    }
    public boolean wardOff(float strength){
        System.out.println("Infantryman ward off with strength " + strength);
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
