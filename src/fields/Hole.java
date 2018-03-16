package fields;

import game.Skeleton;
import things.Thing;

public class Hole extends Field {

    /**
     * Ami rálép az meghívja, a Hole azt megsemmisíti.
     * @param t A rálépő Thing
     * @return 0
     */
    public int Interact(Thing t){
        Skeleton.getInstance.Call(this, t,"Die");
        t.Die();
        Skeleton.getInstance.Return(this);
        return 0;
    }

}
