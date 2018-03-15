package game;

public class Warehouse {

    private String name;
    private int colouredBoxCount;
    private int playerCount;


    public void StartingProcess(){}

    public void CBDecrease() {
        //Színes dobozok száma csökkentése
        colouredBoxCount--;
        //Skeleton singleton osztály lekérdezése és eltárolása
        Skeleton skeleton = Skeleton.getInstance();
        //Színes dobozok száma ellenőrzés
        if (colouredBoxCount == 0) {
            //Hívás előtt a skeleton kiíró függvényét meghívjuk
            skeleton.getInstance().Call(this,skeleton,"EndGame");
            //Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            Game.getInstance().EndGame();
        }
        //Visszatérünk, meghívjuk a visszatérési függvényt
        skeleton.Return(this);
    }
    public void PDecrease(){
        //Játékos dobozok száma csökkentése
        playerCount--;
        //Skeleton singleton osztály lekérdezése és eltárolása
        Skeleton skeleton = Skeleton.getInstance();
        //Játékosok száma ellenőrzés
        if(playerCount==1) {
            //Hívás előtt a skeleton kiíró függvényét meghívjuk
            skeleton.Call(this,skeleton,"EndGame");
            //Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            Game.getInstance().EndGame();
        }
        //Visszatérünk, meghívjuk a visszatérési függvényt
        skeleton.Return(this);
    }
}
