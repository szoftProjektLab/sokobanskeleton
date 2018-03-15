package game;


public class Warehouse {

    private String name;
    private int colouredBoxCount;
    private int playerCount;

    public void StartingProcess(){}

    public void CBDecrease() {
        colouredBoxCount--;
        if (colouredBoxCount == 0) {
            Skeleton.Call();
            Game.EndGame();
        }
        Skeleton.Return();
    }
    public void PDecrease(){
        playerCount--;
        if(playerCount==0) {
            Skeleton.Call();
            Game.EndGame();
        }
        Skeleton.Return();
    }
}
