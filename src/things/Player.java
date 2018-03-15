package things;

import enums.Direction;
import fields.*;

public class Player extends Thing {

    /**
     * A játékos ponjai
     */
    private int points;

    /**
     * A kapott értékkel növeli a Player pontszámának értékét.
     * @param points hozzá adandó pontok száma
     */
    public void AddPoints(int points){
        //call
        this.points += points;
    }

    /**
     *  Ütközteti a Player-t és a kapott Player-t,
     *  nem léphet tovább a cselekvést indító Player.
     * @param d A mozgás iránya
     * @param p Az érkező Player
     * @return
     */
    public int Collide (Direction d, Player p){
        //call
        //???
        return 0;
    }

    /**
     * Ütközeti a Player-t és a Box-ot.
     * @param d A mozgás iránya
     * @param b Az érkező Box
     * @return
     */
    public int Collide (Direction d, Box b){
        //call
        //???
        return 0;
    }

    /**
     * Az egész mozgatást egy irányba elkezdi,
     * majd pontszámát növeli
     * @param d A mozgás iránya
     */
    public void StratMove(Direction d){
        //call
        //trymove
    }

    //???
    public int AcceptMove (Wall w){
        return 0;
    }

    /**
     * Lyukba esés, esetleg amikor egy ládát rátolnak,
     * ebben az esetben ez a mezőről törli és
     * a játékosok számát csökkenti eggyel.
     */
    public void Die(){
        //call
        //delete
    }
}
