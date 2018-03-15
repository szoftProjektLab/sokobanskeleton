package fields;

import game.Skeleton;
import things.Box;

public class Switch extends Field{

    private SpecialHole hole;

    public void SetHole( SpecialHole h){ hole = h;}

    /**
     * Ha egy doboz eltávolítódik a kapcsolóról, a hozzá tartozó lyuk becsukódik
     * @param b A róla távozó doboz
     */
    public void Remove(Box b){
        this.thing=null;

        Skeleton.getInstance.Call(this, hole,"SetOpen");
        hole.SetOpen(false);

        Skeleton.getInstance.Return(this);
    }

    /**
     * A kapcsolóra érkező doboz meghívja, kinyitja a hozzá tartozó lyukat
     * @param b
     * @return
     */
    public int Interact(Box b) {
        Skeleton.getInstance.Call(this, hole,"SetOpen");
        hole.SetOpen(true);
        Skeleton.getInstance.Return(this);
        return 0;
    }

}
