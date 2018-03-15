package things;

import enums.Direction;
import fields.*;

public class Thing {

    public int MakeCollision (Direction d, Thing t){
        return 0;
    }

    public int Collide (Direction d, Thing t){
        return 0;
    }

    public int AcceptMove(Field f){
        return 0;
    }

    public int AcceptMove(Wall w){
        return 0;
    }

    public void Die(){}
}
