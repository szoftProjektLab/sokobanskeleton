import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while(true){
            System.out.println("1: Jatekos tol Ladat\n2: Lada tol Ladat\n3: Jatekos tol Jatekost\n" +
                    "4: Láda tol Jatekost\n5: Jatekos Lyukba esik\n6: Lada Lyukba esik\n7: Szines Lada Szines Mezore kerul\n" +
                    "8: Jatekos falnak megy magatol\n9: Jatekost Falnak toljak\n10: Ladat Falnak toljak");
            System.out.println("\nPlease enter the number of use-case you want to see!");

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
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
