package observer;

import  observer.IDeathObserver;
import  soldier.BaseSoldier;
import java.util.HashSet;
import java.util.Set;
public class DeathCountObserver implements IDeathObserver{
    private Set<BaseSoldier> deathSoldier;
    private static DeathCountObserver instance;
    private DeathCountObserver(){
         deathSoldier = new HashSet<>();
    };
    public static DeathCountObserver getInstance() {
        if (instance == null) {
            instance = new DeathCountObserver();
        }
        return instance;
    }
    @Override 
    public void update (BaseSoldier soldier){
         if (soldier != null){
            deathSoldier.add(soldier);
        }
        displayDeathCount();
    }
    public void displayDeathCount(){
        System.out.println("[DeathCountObserver] So luong nguoi chet hien tai: " + deathSoldier.size());
    }
}