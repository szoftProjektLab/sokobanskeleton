package game;

/**
 * Raktárt viselkedését leíró osztály
 */
public class Warehouse {
    /**
     * Színes dobozok száma
     */
    private int colouredBoxCount;
    /**
     * Játékosok száma
     */
    private int playerCount;

    /**
     * Kezdési folyamat
     */
    public void StartingProcess(){}

    public void setPlayerCount(int szam){
        playerCount = szam;
    }
    public void setColouredBoxCount(int szam){
        colouredBoxCount = szam;
    }

    /**
     * Színes dobozok számát csökkentő függvény, véget vet a játéknak, ha egy feltétel teljesül
     */
    public void CBDecrease() {
        colouredBoxCount--;
        if (Skeleton.getInstance().Option("colouredBoxCount egyenlo 0-val?")) {
             // Játék referencia lekérdezése
            Game game = Game.getInstance();
             // Hívás előtt a skeleton kiíró függvényét meghívjuk
            Skeleton.getInstance().Call(this,game,"EndGame()");
             // Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            game.EndGame();
        }
         // Visszatérünk, meghívjuk a visszatérési függvényt
        Skeleton.getInstance().Return(this);
    }
    /**
     *  Játékosok számát csökkentő függvény, véget vet a játéknak, ha egy feltétel teljesül
     */
    public void PDecrease(){
        playerCount--;
        if(Skeleton.getInstance().Option("playerCount egyenlo 1-el?")) {
             // Játék referencia lekérdezése
            Game game = Game.getInstance();
             //Hívás előtt a skeleton kiíró függvényét meghívjuk
            Skeleton.getInstance().Call(this,game,"EndGame()");
             // Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            game.EndGame();
        }
         // Visszatérünk, meghívjuk a visszatérési függvényt
        Skeleton.getInstance().Return(this);
    }
}
