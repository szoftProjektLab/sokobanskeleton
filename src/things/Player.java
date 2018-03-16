package things;

import enums.Direction;
import fields.*;
import game.Skeleton;

public class Player extends Thing {

    /** A játékos ponjai */
    private int points;

    /**
     * A kapott értékkel növeli a Player pontszámának értékét.
     * @param points hozzá adandó pontok száma
     */
    public void AddPoints(int points){
        this.points += points;
        Skeleton.getInstance().Return(this);
    }

    /**
     *  Ütközteti a Player-t és a kapott Player-t,
     *  nem léphet tovább a cselekvést indító Player.
     * @param d A mozgás iránya
     * @param p Az érkező Player
     * @return
     */
    public int Collide (Direction d, Player p){
        Skeleton.getInstance().Return(this);
        return 0;
    }

    /**
     * Ütközeti a Player-t és a Box-ot. Box tolja a Playert.
     * @param d A mozgás iránya
     * @param b Az érkező Box
     * @return
     */
    public int Collide (Direction d, Box b){
        //tmp: <return field.TryPlyer(d);> szét kellett választani h jó sorrendben fusson a call és return
        Skeleton.getInstance().Call(this, field,"TryMove(d)");
        int tmp = field.TryMove(d);

        Skeleton.getInstance().Return(this);
        return tmp;
    }

    /**
     * Az egész mozgatást egy irányba elkezdi,
     * majd pontszámát növeli
     * @param d A mozgás iránya
     */
    public void StartMove(Direction d){
        Skeleton.getInstance().Call(this, field,"GetNeighbour(d)");
        Field tmp = field.GetNeighbour(d);
        if (Skeleton.getInstance().Option("f1 szomszédja (f2) fal?")){ //5.3.8
            Skeleton.getInstance().Return(this);
        }
    }

    /**
     * Player-t falra toltak meghal
     * @param w A kapott fal ahova lépne
     * @return 0
     */
    public int AcceptMove (Wall w){
        //???
        //delete
        //Skeleton.getInstance.Call(this, field,"Remove");
        //field.Remove(this);

        Skeleton.getInstance().Return(this);
        return 0;
    }

    /**
     * Lyukba esés, esetleg amikor egy ládát rátolnak,
     * ebben az esetben ez a mezőről törli és
     * a játékosok számát csökkenti eggyel.
     */
    public void Die(){
        Skeleton.getInstance().Call(this, field,"PDecrease()");
        warehouse.PDecrease();

        Skeleton.getInstance().Call(this, field,"Remove(t)");
        field.Remove(this);

        Skeleton.getInstance().Return(this);
    }
    public void SetField(Field f)
    {
        field = f;
    }
}
