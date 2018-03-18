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
        if (tmp instanceof Wall){ //5.3.8
            //fal
        }else{
            String name = Skeleton.getInstance().GetName(this);
            Skeleton.getInstance().Call(this, field,"TryMove(d, "+name+")");
            tmp.TryMove(d, this);
        }
        Skeleton.getInstance().Return(this);
    }

    /**
     * Player-t falra toltak meghal
     * @param w A kapott fal ahova lépne
     * @return 0
     */
    public int AcceptMove (Wall w){
        Skeleton.getInstance().Call(this,this,"Die()");
        Die();
        Skeleton.getInstance().Return(this);
        return 0;
    }

    /**
     * Lyukba esés, esetleg amikor egy ládát rátolnak,
     * ebben az esetben ez a mezőről törli és
     * a játékosok számát csökkenti eggyel.
     */
    public void Die(){
        Skeleton.getInstance().Call(this, warehouse,"PDecrease()");
        warehouse.PDecrease();

        String name = Skeleton.getInstance().GetName(this);
        Skeleton.getInstance().Call(this, field,"Remove("+name+")");
        field.Remove(this);

        Skeleton.getInstance().Return(this);
    }

}
