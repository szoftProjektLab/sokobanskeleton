import java.util.Scanner;
import things.*;
import game.*;
import enums.*;
import display.*;
import fields.*;


public class Main {

    public static void main(String[] args) {

        while(true){

            System.out.print(
                    "\n\n\n\n"+
                    "------------------------------------------\n" +
                    "| Please select a use-case:              |\n" +
                    "------------------------------------------\n" +
                    "| 1:  Jatekos tol Ladat                  |\n" +
                    "| 2:  Lada tol Ladat                     |\n" +
                    "| 3:  Jatekos tol Jatekost               |\n" +
                    "| 4:  Láda tol Jatekost                  |\n" +
                    "| 5:  Jatekos Lyukba esik                |\n" +
                    "| 6:  Lada Lyukba esik                   |\n" +
                    "| 7:  Szines Lada Szines Mezore kerul    |\n" +
                    "| 8:  Jatekos falnak megy magatol        |\n" +
                    "| 9:  Jatekost Falnak toljak             |\n" +
                    "| 10: Ladat Falnak toljak                |\n" +
                    "------------------------------------------\n" +
                    "-> Selected use-case: "
            );
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            System.out.print("\n\n\n");

            Field f0, f1,f2,f3;
            Wall w1;
            Box b1, b2;
            Player p, p1, p2;
            Hole h;
            Warehouse w;
            Game g;
            ColouredField cf;
            ColouredBox cb;

            Skeleton sk = Skeleton.getInstance();

            switch(choice) {
                    case 1:
                        //5.3.1 Jatekos tol Ladat
                        b1 = new Box();
                        f1 = new Field();
                        f2 = new Field();
                        f3 = new Field();
                        p1 = new Player();
                        sk.Add(f1,"f1");
                        sk.Add(f2,"f2");
                        sk.Add(f3,"f3");
                        sk.Add(p1,"p1");
                        sk.Add(b1,"b1");
                        f2.SetThing(b1);
                        b1.SetField(f2);
                        f2.SetNeighbour(Direction.Right,f3);
                        b1.Collide(Direction.Right,p1);
                        sk.Clear();
                        break;

                    case 2:
                        // 5.3.2 Láda tol Ládát
                        b1 = new Box();
                        b2 = new Box();
                        f0 = new Field();
                        f1 = new Field();
                        f2 = new Field();
                        f0.SetNeighbour(Direction.Right, f1);
                        f1.SetNeighbour(Direction.Right, f2);
                        b1.SetField(f0);
                        f0.SetThing(b1);
                        b2.SetField(f1);
                        f1.SetThing(b2);
                        sk.Add(b1,"Box1");
                        sk.Add(b2,"Box2");
                        sk.Add(f0,"Field0");
                        sk.Add(f1,"Field1");
                        sk.Add(f2,"Field2");
                        Skeleton.getInstance().Call(b1,b2,"Collide(Direction.Right, b1)");
                        b2.Collide(Direction.Right, b1);
                        sk.Clear();
                        break;

                    case 3:
                        //5.3.3 Játékos tol Játékost
                        f1 = new Field();
                        f2 = new Field();
                        f1.SetNeighbour(Direction.Right, f2);
                        p1 = new Player();
                        p2 = new Player();
                        p1.SetField(f1);
                        f1.SetThing(p1);
                        p2.SetField(f2);
                        f2.SetThing(p2);
                        sk.Add(f1,"Field1");
                        sk.Add(f2,"Field2");
                        sk.Add(p1,"Player1");
                        sk.Add(p2,"Player2");
                        Skeleton.getInstance().Call(p1,p2,"Collide(Direction.Right, p1)");
                        p2.Collide(Direction.Right, p1);
                        sk.Clear();
                        break;

                    case 4:
                        b1 = new Box();
                        p1 = new Player();
                        f0 = new Field();
                        f1 = new Field();
                        f2 = new Field();
                        f0.SetNeighbour(Direction.Right, f1);
                        f1.SetNeighbour(Direction.Right, f2);
                        b1.SetField(f0);
                        f0.SetThing(b1);
                        p1.SetField(f1);
                        f1.SetThing(p1);
                        sk.Add(b1,"Box1");
                        sk.Add(p1,"Player1");
                        sk.Add(f0,"Field0");
                        sk.Add(f1,"Field1");
                        sk.Add(f2,"Field2");
                        Skeleton.getInstance().Call(b1,p1,"Collide(Direction.Right, p1)");
                        p1.Collide(Direction.Right, b1);
                        sk.Clear();
                        break;

                    case 5:
                        h = new Hole();
                        p1 = new Player();
                        p2 = new Player();
                        w = new Warehouse();
                        g = new Game();
                        sk.Add(h, "Hole");
                        sk.Add(p1, "Player");
                        sk.Add(p2, "Main");
                        sk.Add(w, "Warehouse");
                        sk.Add(g, "Game");

                        p1.setWarehouse(w);
                        w.setPlayerCount(3);
                        p1.SetField(h);
                        h.SetThing(p1);
                        Skeleton.getInstance().Call(p2,h,"Interact(Player)");
                        h.Interact(p1);
                        break;

                    case 6:
                        h = new Hole();
                        b1 = new Box();
                        p = new Player();

                        sk.Add(h, "Hole");
                        sk.Add(b1, "Box1");
                        sk.Add(p,"Main");

                        b1.SetField(h);
                        h.SetThing(b1);
                        Skeleton.getInstance().Call(p,h,"Interact(b1)");
                        h.Interact(b1);
                        break;

                    case 7:
                        cf = new ColouredField();
                        cb = new ColouredBox();
                        w = new Warehouse();
                        g = new Game();
                        p = new Player();

                        w.setColouredBoxCount(2);
                        cf.SetBox(cb);
                        cf.SetThing(cb);
                        cb.SetField(cf);
                        cb.setWarehouse(w);

                        sk.Add(p, "Main");
                        sk.Add(cf, "ColouredField");
                        sk.Add(cb, "ColouredBox");
                        sk.Add(w, "Warehouse");
                        sk.Add(g, "Game");

                        Skeleton.getInstance().Call(p, cf, "Interact(cb)");
                        cf.Interact(cb);
                        break;

                    case 8:
                        p = new Player();
                        p2 = new Player();
                        f1 = new Field();
                        w1 = new Wall();
                        p.SetField(f1);
                        f1.SetNeighbour(Direction.Right,w1);
                        sk.Add(p,"Player1");
                        sk.Add(p2, "Main");
                        sk.Add(f1,"Field1");
                        sk.Add(w1,"Wall1");
                        Skeleton.getInstance().Call(p2,p,"StartMove(Direction.Right)");
                        p.StartMove(Direction.Right);
                        break;

                    case 9:
                        p1 = new Player();
                        f1 = new Field();
                        w = new Warehouse();
                        g = new Game();
                        w1 = new Wall();    //a fal osztály nincs megírva

                        w.setPlayerCount(3);
                        p1.SetField(w1);
                        w1.SetThing(p1);
                        p1.setWarehouse(w);
                        sk.Add(p1, "Player");
                        sk.Add(f1, "Field");
                        sk.Add(w, "Warehouse");
                        sk.Add(g, "Game");
                        sk.Add(w1, "Wall");
                        Skeleton.getInstance().Call(w1,p1,"AcceptMove(Wall)");
                        p1.AcceptMove(w1);
                        break;

                    case 10:
                        b1 = new Box();
                        w1 = new Wall();

                        sk.Add(b1, "Box");
                        sk.Add(w1, "Wall");

                        Skeleton.getInstance().Call(w1,b1,"AcceptMove(Wall)");
                        b1.AcceptMove(w1);

                        break;

                    default:
                        System.out.println(
                                "\n\n\n"+
                                "Selected use-case does not exist! \n"+
                                "Please type a number between 1 and 10.");
                        break;
            }

            System.out.flush();
            System.out.println(
                        "\n\n\n\n"+
                        "------------------------------\n"+
                        "   Press Enter to continue!   \n"+
                        "------------------------------\n"
            );
            // Várakozás enterre
            Scanner console = new Scanner(System.in);
            console.nextLine();
            // új üres sorok beszúrása
            for (int i = 0; i < 20; i++) System.out.println();


        }
    }
}
