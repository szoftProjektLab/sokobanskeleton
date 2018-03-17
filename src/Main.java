import java.util.Scanner;
import things.*;
import game.*;
import enums.*;
import display.*;
import fields.*;


public class Main {

    public static void main(String[] args) {

        while(true){
            System.out.println("1: Jatekos tol Ladat\n2: Lada tol Ladat\n3: Jatekos tol Jatekost\n" +
                    "4: Láda tol Jatekost\n5: Jatekos Lyukba esik\n6: Lada Lyukba esik\n7: Szines Lada Szines Mezore kerul\n" +
                    "8: Jatekos falnak megy magatol\n9: Jatekost Falnak toljak\n10: Ladat Falnak toljak");
            System.out.println("\nPlease enter the number of use-case you want to see!");

            Scanner in = new Scanner(System.in);
            Field f1,f2,f3;
            Wall w1;
            Box b1;
            Player p1, p2;
            Hole h;
            Warehouse w;
            Game g;

                int choice = in.nextInt();
                Skeleton sk = Skeleton.getInstance();
                switch(choice) {
                    case 1:
                        b1 = new Box();
                        f1 = new Field();
                        f2 = new Field();
                        f3 = new Field();
                        p1 = new Player();
                        sk.Add(f1,"f1");sk.Add(f2,"f2");sk.Add(f3,"f3");sk.Add(p1,"p1");sk.Add(b1,"b1");
                        f2.SetThing(b1);
                        b1.SetField(f2);
                        f2.SetNeighbour(Direction.Right,f3);
                        b1.Collide(Direction.Right,p1);
                        break;
                    case 2:
                        //5.3.1 Jatekos tol Ladat
                        b1 = new Box();
                        f2 = new Field();
                        f3 = new Field();
                        p1 = new Player();
                        break;
                    case 3:
                        //Erik egy kuki
                        break;
                    case 4:
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
                        /*Skeleton.getInstance().Call(h,p1,"Die()");
                        p1.Die();
                        Skeleton.getInstance().Call(p1,w,"PDecrease()");
                        w.PDecrease();
                        Skeleton.getInstance().Call(p1,h,"Remove(p1)");
                        h.Remove(p1);*/

                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        Player p = new Player();
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
                        break;
                    case 10:
                        break;
                    default:
                        System.out.flush();
                        System.out.println("\nKerem adjon meg egy szamot 1 es 10 kozott!\n");
                        break;
                }


        }
    }
}
