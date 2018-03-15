package fields;

import display.Colours;
import game.Skeleton;
import things.ColouredBox;
import things.Thing;

public class ColouredField extends Field{

    private Colours colour;
    //private ColouredBox box; //thing==box nem lehet
    private Thing box;

    public void InitColour(){
        //???
    }

    /**
     * Ha színes láda kerül rá, ellenőrzi, hogy a hozzá tartozó áll e rajta,
     * ha igen, pontot ad és kitörli.
     * @param cb Rajta álló színes láda
     * @return pont
     */
    public int Interact(ColouredBox cb){
        int tmp=0;
        if (thing==box){
            tmp=1;
            Skeleton.getInstance.Call(this, thing,"Die");
            thing.Die();
        }
        Skeleton.getInstance.Return(this);
        return tmp;
    }
}
