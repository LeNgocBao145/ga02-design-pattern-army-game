package factory;
import equipment.SoldierDecorator;
import equipment.SoldierProxy;
import equipment.Sword;
import equipment.Armor;
import equipment.Spear;

public  class Medieval extends GenerationFactory {
   
    public Medieval(){
        addEquipment(Sword.class);
        addEquipment(Spear.class);
        addEquipment(Armor.class);
    }

 
}
