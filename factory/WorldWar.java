package factory;
import equipment.SoldierDecorator;
import equipment.SoldierProxy;
import equipment.Rifle;
import equipment.Grenade;
import equipment.Helmet;

public  class WorldWar extends GenerationFactory {
   
    public WorldWar(){
        addEquipment(Rifle.class);
        addEquipment(Grenade.class);
        addEquipment(Helmet.class);
    }

 
}
