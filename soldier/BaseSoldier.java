package soldier;

import observer.DeathNotifierObserver;
import observer.DeathCountObserver;
import observer.IDeathObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseSoldier implements Soldier {
    protected float hp;
    protected float strength;
    public String name;
    List<IDeathObserver> observers;

    BaseSoldier(float hp, float strength, String name) {
        this.hp = hp;
        this.strength = strength;
        this.name = name;
        IDeathObserver counter = DeathCountObserver.getInstance();
        IDeathObserver notifier = DeathNotifierObserver.getInstance();
        this.observers = new ArrayList<>();
        this.observers.add(counter);
        this.observers.add(notifier);
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void notifyObservers(){
        System.out.println(this.getClass().getSimpleName());
        for (IDeathObserver obs : observers) {
            obs.update(this); 
        }
    }
}
