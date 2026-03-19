package army;

import equipment.SoldierDecorator;
import visitor.ArmyVisitor;

public interface ArmyComponent {
    public float hit();
    public boolean wardOff(float strength);
    public void addEquipment(Class<? extends SoldierDecorator> type);
    public String getName();
    public void accept(ArmyVisitor visitor);
}
