package observer;

import  observer.IDeathObserver;
import  soldier.BaseSoldier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class DeathNotifierObserver implements IDeathObserver{
    private Set<BaseSoldier> deathSoldier;
     private static DeathNotifierObserver instance;
    private DeathNotifierObserver(){
        deathSoldier = new HashSet<>();
    };
    public static DeathNotifierObserver getInstance() {
        if (instance == null) {
            instance = new DeathNotifierObserver();
        }
        return instance;
    }
    public void update (BaseSoldier soldier){
        if (soldier != null){
            deathSoldier.add(soldier);
        }
        displayDeathSoldierList();
    }
    public void displayDeathSoldierList(){
        System.out.print("[DeathNotifierObserver]: ");
         int i = 1;
        for (BaseSoldier s : deathSoldier) {
            System.out.print(s.getName() + " ");
            i++;
        }
         System.out.println("");
    }
}

