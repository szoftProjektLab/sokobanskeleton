package game;

public class Game {

    private static Game game = new Game();
    private Warehouse running;
    private Game(){}

    public static Game getInstance(){
        return game;
    }
    public void StartGame(){}
    public void setRunning(Warehouse r){running = r; }
    public void EndGame(){
        Skeleton.getInstance().Clear();
    }
}
