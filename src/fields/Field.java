package fields;

import enums.Direction;
import game.Skeleton;
import things.Thing;

import java.util.HashMap;
import java.util.Map;

public class Field {

    private Map<Direction,Field> neighbours;
    protected Thing thing;

    /**
     * Konstruktor: neighbours map inicializálása
     */
    public Field(){
        //Kell konstruktorba? Skeleton.getInstance.Return(this);
        neighbours = new HashMap<Direction,Field>();
    }

    /**
     * Az adott irányba beállítja a szomszédos mezőt.
     * @param d irány
     * @param f szomszédnak szánt Field
     */
    public void SetNeighbour(Direction d, Field f){
        //Kell setterbe? Skeleton.getInstance.Return(this);
        neighbours.put(d, f);
    }

    /**
     * Visszaadja abban az irányban lévő szomszédos mezőt
     * !!csak skeletonban
     * @param d Szomszéd iránya
     * @return
     */
    public Field GetNeighbour(Direction d){
        Skeleton.getInstance().Return(this);
        return neighbours.get(d);
    }

    /**
     * Egy tárgyat hozzácsatol az aktuális mezőhöz.
     * @param t A csatolandó tárgy
     * @return 0
     */
    public int Add(Thing t){
        this.thing = t;
        Skeleton.getInstance().Call(this, this, "Interact");
        int tmp = Interact(t);
        Skeleton.getInstance().Return(this);
        return tmp;
    }

    /**
     * Az éppen rajta álló tárgyat eltávolítja a mezőről
     */
    public void Remove(Thing t){
        this.thing = null;
        Skeleton.getInstance().Return(this);
    }

    /**
     * Virtuális függvény, itt nem csinál semmit
     * @param t
     * @return
     */
    public int Interact(Thing t){ return 0;}


    /**
     * A mezőn álló játékos ezzel jelzi helyváltoztatási szándékát.
     * @param d A mozgás iránya
     * @return
     */
    public int TryMove(Direction d){
        //return neighbours.get(d).TryMove(d, this.thing);
        Skeleton.getInstance().Call(this, neighbours.get(d), "TryMove");
        int tmp = neighbours.get(d).TryMove(d, this.thing);

        Skeleton.getInstance().Return(this);
        return tmp;
    }

    /**
     * A szomszédos mező a felőle érkező mozgás igényt ennek meghívásával jelzi.
     * @param d A mozgás iránya
     * @param t Az érkezni kívánó Thing
     * @return
     */
    public int TryMove(Direction d, Thing t){
        int tmp =0;
        if (this.thing==null){
            Skeleton.getInstance().Call(this, t, "AcceptMove");
            tmp = t.AcceptMove(this);
        } else{
            Skeleton.getInstance().Call(this, t, "MakeCollision");
            tmp = t.MakeCollision(d, this.thing);
        }
        Skeleton.getInstance().Return(this);
        return tmp;
    }


}
