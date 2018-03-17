package things;

import enums.Direction;
import game.Skeleton;

public class Box extends Thing {

    /**
     * Egy, a doboz által elfoglalt mezőre érkezni kívánó játékos(Player) vagy doboz(Box) hívja meg.
     * További mozgást kezdeményez a megadott irányban. Ha a mozgások során színes láda kerül neki
     * megfelelő helyre, visszaadja / továbbítja a megszerzett pontszámot a hívó felé.

     * @param d A mozgás iránya
     * @param t Az érkező Thing
     * @return
     */
    public int Collide(Direction d, Thing t){
        Skeleton.getInstance().Call(this, field,"TryMove(d)");
        int tmp = field.TryMove(d);

        Skeleton.getInstance().Return(this);
        return tmp;
    }

    /**
     * Hole-ra érkezve meghívódik ez a metódust
     */
    public void Die(){
        String name = Skeleton.getInstance().GetName(this);
        Skeleton.getInstance().Call(this, field,"Remove("+name+")");
        field.Remove(this);

        Skeleton.getInstance().Return(this);
    }
}
