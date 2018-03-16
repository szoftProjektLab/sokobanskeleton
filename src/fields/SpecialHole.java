package fields;

import game.Skeleton;
import things.Thing;

public class SpecialHole extends Hole {

    private boolean open;

    /**
     * Ami rálép az meghívja, Ha nyitva van, megsemmisíti.
     * @param t A rálépő Thing
     * @return
     */
    public int Interact(Thing t){
        if(open){
            Skeleton.getInstance.Call(this, t,"Die");
            t.Die();
        }
        Skeleton.getInstance.Return(this);
        return 0;
    }

    /**
     * Beállítja, hogy nyitva van-e a lyuk
     * @param op
     */
    public void SetOpen(boolean op) {
        open=op;
        Skeleton.getInstance.Return(this);
    }

}
