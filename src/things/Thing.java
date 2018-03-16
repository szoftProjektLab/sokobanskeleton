package things;

import enums.Direction;
import fields.*;
import game.Skeleton;
import game.Warehouse;

public class Thing {

    Warehouse warehouse;
    Field field;

    /**
     * Ha a helyet változtató Thing új Field-jén áll egy Thing, ez hívja meg,
     * hogy értesítse
     * @param d A mozgás iránya
     * @param t A használni kívánt mezőt elfogaló Thing
     * @return
     */
    public int MakeCollision (Direction d, Thing t){
        Skeleton.getInstance().Call(this, t,"Collide(d, t)");
        int tmp = t.Collide(d, this);

        Skeleton.getInstance().Return(this);
        return tmp;
    }

    /**
     * A leszármazottak felüldefiniálják. Az érkező Thing hívja.
     * @param d A mozgás iránya
     * @param t Az érkező Thing
     * @return 0
     */
    public int Collide (Direction d, Thing t){
        return 0;
    }

    /**
     * Végrehajtja a léptetést. A használni kívánt szabad mező hívja
     * @param f az új mező
     * @return
     */
    public int AcceptMove(Field f){
        Skeleton.getInstance().Call(this, field,"Remove(t)");
        field.Remove(this);

        Skeleton.getInstance().Call(this, f,"Add(t)");
        int tmp = f.Add(this);

        Skeleton.getInstance().Return(this);
        return tmp;
    }

    /**
     * Nem csinál semmit
     * @param w A kapott fal, amire lépnie kéne.
     * @return 0
     */
    public int AcceptMove(Wall w){
        Skeleton.getInstance().Return(this);
        return 0;
    }

    /**
     * A leszármazottak felüldefiniálják
     */
    public void Die(){}
    public void SetField(Field f)
    {
        field = f;
    }
}
