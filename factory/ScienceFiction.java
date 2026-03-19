package factory;
import equipment.LaserSword;
import equipment.BiologicalWeapon;
import equipment.NanoArmor;

public  class ScienceFiction extends GenerationFactory {
   
    public ScienceFiction(){
        addEquipment(LaserSword.class);
        addEquipment(BiologicalWeapon.class);
        addEquipment(NanoArmor.class);
    }

 
}
