package things;

import enums.Direction;
import fields.*;
import game.Skeleton;
import game.Warehouse;

public class Thing {

    Warehouse w;
    Field f;

    //??? mozogni kívánó, használni kívánt fieldet elfoglaló??
    /**
     * Ha a helyet változtató Thing új Field-jén áll egy Thing, ezzel értesül
     * @param d
     * @param t
     * @return
     */
    public int MakeCollision (Direction d, Thing t){
        //call
        //???
        return 0;
    }

    /**
     * Az érkező Thing hívja
     * @param d A mozgás iránya
     * @param t Az érkező Thing
     * @return
     */
    public int Collide (Direction d, Thing t){
        return 0;
    }

    /**
     * Végrehajtja a léptetést
     * @param f az új mező
     * @return
     */
    public int AcceptMove(Field f){
        Skeleton.getInstance.Call();

        f.Remove(this);
        f.Add(this);

        return 0; //???
    }

    /**
     * ????????????????????????????????
     * @param w
     * @return
     */
    public int AcceptMove(Wall w){
        //call
        //???
        return 0;
    }

    /**
     * Overriden by descendant classes
     */
    public void Die(){}
}
