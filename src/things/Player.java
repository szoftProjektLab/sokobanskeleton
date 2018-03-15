package things;

import enums.Direction;
import fields.*;

public class Player extends Thing {

    private int points;

    public void AddPoints(int points){
        this.points += points;
    }

    public int Collide (Direction d, Player p){
        return 0;
    }

    public int Collide (Direction d, Box b){
        return 0;
    }

    public void StratMove(Direction d){

    }

    public int AcceptMove (Wall w){
        return 0;
    }

    public void Die(){}
}
