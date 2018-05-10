package game;

public class Game {

    /**
     * Saját magáról példány <<Singleton>>
     */
    private static Game game = new Game();
    /**
     * Raktárról tárolt referencia
     */
    private Warehouse running;

    /**
     * A magából készült példány elérése.
     * @return A saját magából létrehozott példány.
     */
    public static Game getInstance(){
        return game;
    }

    /**
     * Játék kezdését biztosító folyamat, még nem megvalósított
     */
    public void StartGame(){}

    /**
     * Jelenlegi raktár referencia beállítása
     * @param r Raktár
     */
    public void setRunning(Warehouse r){running = r; }

    /**
     * Játék befejezését biztosító folyamat
     */
    public void EndGame(){
        Skeleton.getInstance().LevelDecrease();
    }
}
