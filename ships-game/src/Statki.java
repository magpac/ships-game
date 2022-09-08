/**
 * 1. nazwy i teksty po angielsku
 * 2. czyKoniecGry w Plansza zmienić na czyZawieraZnak(Character znak) i dostosować odpowiednio Gracza
 * 3. main z prostym wczytywaniem danych z konsoli
 */

public class Statki {

     public static void main(String[] args) {
         Player g1 = new Player(10, 10);
         Player g2 = new Player(10, 10);
         // 1 statek 1 gracza:
        try {
            g1.setShip(3, 6, true, 4);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
         g1.displayOwnBoard();
         System.out.println();
         // 1 statek 2 gracza:
        try {
            g2.setShip(2, 0, false, 1);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
         g2.displayOwnBoard();
         System.out.println();
         // 1 strzal 1 gracza:
        try {
            g1.ownShotEffect(2, 0, g2.enemyShot(2, 0));
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

         if (g2.gameOver() == true) {
             System.out.println("Koniec gry. Wygrał gracz 1.");
         }
        // 1 strzal 2 gracza
         try {
             g2.ownShotEffect(6, 6, g1.enemyShot(6, 6));
         } catch (InvalidOperationException e) {
             System.out.println(e.getMessage());
         }

         if (g1.gameOver() == true) {
             System.out.println("Koniec gry. Wygrał gracz 2.");
         }


        g1.displayEnemyBoard();
        System.out.println();

        g2.displayEnemyBoard();


        /* Plansza planszaWlasna = new Plansza(10,10);
         planszaWlasna.UstawStatek(0,0,false,5);
         planszaWlasna.Wyswietl();
         planszaWlasna.UstawPole(0,0, "X");
         planszaWlasna.Wyswietl();
         System.out.println(planszaWlasna.StatusPola(0,0));

         System.out.println();

         Plansza planszaWroga = new Plansza(10,10);
         planszaWroga.UstawStatek(4,9,true,5);
         planszaWroga.Wyswietl(); */

    }
}
