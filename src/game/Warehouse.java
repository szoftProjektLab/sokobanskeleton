package game;

public class Warehouse {

    //Színes dobozok száma
    private int colouredBoxCount;
    //Játékosok száma
    private int playerCount;

    //Kezdési folyamat
    public void StartingProcess(){}

    public void CBDecrease() {
        //Színes dobozok száma csökkentése
        colouredBoxCount--;
        //Színes dobozok száma ellenőrzés
        if (colouredBoxCount == 0) {
            //Játék referencia lekérdezése
            Game game = Game.getInstance();
            //Hívás előtt a skeleton kiíró függvényét meghívjuk
            Skeleton.getInstance().Call(this,game,"EndGame");
            //Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            game.EndGame();
        }
        //Visszatérünk, meghívjuk a visszatérési függvényt
        Skeleton.getInstance().Return(this);
    }

    public void PDecrease(){
        //Játékos dobozok száma csökkentése
        playerCount--;
        //Játékosok száma ellenőrzés
        if(playerCount==1) {
            //Játék referencia lekérdezése
            Game game = Game.getInstance();
            //Hívás előtt a skeleton kiíró függvényét meghívjuk
            Skeleton.getInstance().Call(this,game,"EndGame");
            //Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            game.EndGame();
        }
        //Visszatérünk, meghívjuk a visszatérési függvényt
        Skeleton.getInstance().Return(this);
    }
}
