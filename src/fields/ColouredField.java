package fields;

import display.Colours;
import game.Skeleton;
import things.ColouredBox;

public class ColouredField extends Field{

    /** A színe */
    private Colours colour;

    /** A hozzá tartozó doboz */
    private ColouredBox box;

    public void SetBox(ColouredBox cb){ box=cb; }
    private void SetColour(Colours c){ this.colour = c; }

    /**
     * Beállítja a saját és a hozzá tartozó színes doboz színét.
     */
    public void InitColour(){
        //inithez kell?// Skeleton.getInstance.Call(this, ,"RandomColour");
        Colours c = Colours.RandomColour();

        //inithez kell?// Skeleton.getInstance.Call(this, this,"SetColour");
        SetColour(c);

        //inithez kell?// Skeleton.getInstance.Call(this, box,"SetColour");
        box.SetColour(c);

        //inithez kell?// Skeleton.getInstance.Return(this);
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
            Skeleton.getInstance().Call(this, thing,"Die");
            thing.Die();
        }
        Skeleton.getInstance().Return(this);
        return tmp;
    }
}
