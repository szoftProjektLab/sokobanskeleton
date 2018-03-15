package fields;

import enums.Direction;
import things.Thing;

public class Field {

    private Direction neighbours;
    protected Thing thing;


    public void SetNeighbour(Direction d, Field f){}

    public int Add(Thing t){ return 0;}

    public void Remove(){}

    public int Interact(Thing t){ return 0;}

    public int TryMove(Direction d){return 0;}

    public int TryMove(Direction d, Thing t){return 0;}


}
