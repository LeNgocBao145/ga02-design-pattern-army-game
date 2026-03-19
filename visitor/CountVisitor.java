package visitor;

import soldier.Horseman;
import soldier.Infantryman;

public class CountVisitor implements ArmyVisitor{
   
    private int infantryCount = 0;
    private int horsemanCount = 0;

  
    @Override
    public void visit(Infantryman infantryman) {
        infantryCount++;
    }

  
    @Override
    public void visit(Horseman horseman) {
        horsemanCount++;
    }

    
    public void showReport() {
        System.out.println("=== REPORT OF THE QUANLITY SOLIDER===");
        System.out.println("- Infantryman : " + infantryCount);
        System.out.println("- Horseman: " + horsemanCount);
        System.out.println("- Total: " + (infantryCount + horsemanCount));
        
    }
}
