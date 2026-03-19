package factory;


import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;
import equipment.SoldierDecorator;
import equipment.SoldierProxy;
import soldier.Infantryman;
import soldier.Horseman;

public abstract class GenerationFactory{
    protected  final Set<Class<? extends SoldierDecorator>> equipments = new HashSet<>();
    public GenerationFactory(){
    }
    public  SoldierProxy createInfantryman(){
         return new SoldierProxy(new Infantryman(), this.equipments);
    };
    public  SoldierProxy createHorseman(){
        return new SoldierProxy(new Horseman(), this.equipments);
    };
    public  SoldierProxy createInfantryman(String name){
         return new SoldierProxy(new Infantryman(name), this.equipments);
    };
    public  SoldierProxy createHorseman(String name){
        return new SoldierProxy(new Horseman(name), this.equipments);
    };
    public  void addEquipment(Class<? extends SoldierDecorator> equipment){
        this.equipments.add(equipment);
    }
}
