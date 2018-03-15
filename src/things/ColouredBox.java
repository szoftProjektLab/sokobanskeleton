package things;

import display.Colours;

public class ColouredBox extends Box{

    Colours cloour;

    /**
     * Ha Hole-ra lép, ez meghívódik és megsemmisül a ColouredBox,
     * meghívja a Warehouse  CBDecrease() metódusát.
     */
    public void Die(){
        //call
        w.CBDecrease();
        //delete
    }
}