package things;

import display.Colours;
import game.Skeleton;

public class ColouredBox extends Box{

    Colours colour;

    /**
     * Ha Hole-ra lép, ez meghívódik és megsemmisül a ColouredBox,
     * meghívja a Warehouse  CBDecrease() metódusát.
     */
    public void Die(){
        Skeleton.getInstance().Call(this, warehouse,"CBDecrease()");
        warehouse.CBDecrease();

        Skeleton.getInstance().Call(this, field,"Remove(t)");
        field.Remove(this);

        Skeleton.getInstance().Return(this);
    }
    public void SetColour(Colours c){ colour = c;}
}