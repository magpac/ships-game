import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 1. nazwy i teksty po angielsku
 * 2. czyKoniecGry w Plansza zmienić na czyZawieraZnak(Character znak) i dostosować odpowiednio Gracza
 * 3. main z prostym wczytywaniem danych z konsoli:
 * gracz 2 sztywno ustawione statki ma. gracz 1 statki wczytywane z konsoli (petla ktora sprawdzi czy sa dobre wspolrzedne) . kazdy z graczy ma po 2 statki (czworka i jedynka).
 * strzal gracza z konsoli (znowu ta petla while), po kazdym poprawnym ruchu wczytac dwie plansze (jego i wroga). Symuluje strzal gracza 2(komputer, losowanie).
 * po kazdym strzale sprawdza sie czy ktos juz nie wygral
 */

public class Ships {

     public static void main(String[] args) {
         Player p1 = new Player(10, 10);
         Player p2 = new Player(10, 10);

         // 1st ship of 1st player:
         Scanner scan = new Scanner(System.in);
         while (true) {
             try {
                 System.out.println("Specify the location of the first ship of length 1.");
                 System.out.println("Row:");
                 int row = scan.nextInt();
                 System.out.println("Column:");
                 int column = scan.nextInt();

                 p1.setShip(row, column, true, 1);
                 break;
             } catch (InvalidOperationException e) {
                 System.out.println(e.getMessage());
             }
         }

         // 2nd ship of 1st player:
         while (true) {
             try {
                 System.out.println("Specify the location of the first ship of length 4.");
                 System.out.println("Row:");
                 int row = scan.nextInt();
                 System.out.println("Column:");
                 int column = scan.nextInt();
                 System.out.println("Is it vertical? Type true or false:");
                 boolean isVertical = scan.nextBoolean();

                 p1.setShip(row, column, isVertical, 4);
                 break;
             } catch (InvalidOperationException e) {
                 System.out.println(e.getMessage());
             }
         }
         System.out.println("This is your board:");
         p1.displayOwnBoard();
         System.out.println();

        // 1st ship of 2nd player:
        try {
            p2.setShip(0, 9, false, 1);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        // 2nd ship of 2nd player:
         try {
             p2.setShip(2, 0, false, 4);
         } catch (InvalidOperationException e) {
             System.out.println(e.getMessage());
         }
         System.out.println("This is board of 2nd player:");
         p2.displayOwnBoard();
         System.out.println();
/*
         // 1 strzal 1 gracza:
        try {
            p1.ownShotEffect(2, 0, p2.enemyShot(2, 0));
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

         if (p2.isGameOver()) {
             System.out.println("Koniec gry. Wygrał gracz 1.");
         }
        // 1 strzal 2 gracza
         try {
             p2.ownShotEffect(6, 6, p1.enemyShot(6, 6));
         } catch (InvalidOperationException e) {
             System.out.println(e.getMessage());
         }

         if (p1.isGameOver() == true) {
             System.out.println("Koniec gry. Wygrał gracz 2.");
         }


        p1.displayEnemyBoard();
        System.out.println();

        p2.displayEnemyBoard();
*/


    }
}
