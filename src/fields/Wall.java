package fields;

import enums.Direction;
import game.Skeleton;
import things.Thing;

public class Wall extends Field{

    Direction reversed;

    public int TryMove(Direction d, Thing t){
        switch(d) {
            case Right:
                reversed = Direction.Left;
                break;
            case Left:
                reversed = Direction.Right;
                break;
            case Up:
                reversed = Direction.Down;
                break;
            case Down:
                reversed = Direction.Up;
                break;
        }
        int tmp =0;
        Skeleton.getInstance().Call(this, t, "AcceptMove(This)");
        tmp = t.AcceptMove(this);
        Skeleton.getInstance().Return(this);
        return tmp;
    }

    public void BackTrack(){
        if(this.thing != null && reversed != null){
            Skeleton.getInstance().Call(this, neighbours.get(reversed), "TryMove");
            neighbours.get(reversed).TryMove(reversed, this.thing);
            if (this.thing != null){
                Skeleton.getInstance().Call(this, this.thing, "Die");
                this.thing.Die();
            }
        }
        Skeleton.getInstance().Return(this);
    }
}
