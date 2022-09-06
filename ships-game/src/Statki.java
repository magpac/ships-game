/**
 * 1. nazwy metod z malej litery
 * 2. nie zakladamy poprawnosci danych (rzucanie wyjatkow)
 * 3. sprawdzanie warunkow zwyciestwa: po kazdym strzale sprawdzic czy gra sie juz nie skonczyla
 */

public class Statki {

     public static void main(String[] args) {
         Gracz g1 = new Gracz(10, 10);
         Gracz g2 = new Gracz(10, 10);
         // 1 statek 1 gracza:
        try {
            g1.ustawStatek(3, 6, true, 4);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
         g1.wystwietlWlasnaPlansze();
         System.out.println();
         // 1 statek 2 gracza:
        try {
            g2.ustawStatek(2, 0, false, 1);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
         g2.wystwietlWlasnaPlansze();
         System.out.println();
         // 2 statek 1 gracza:
       /* try {
            g1.ustawStatek(5, 4, false, 4);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
         // 2 statek 2 gracza:
        try {
            g2.ustawStatek(9, 6, false, 3);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        } */
         // 1 strzal 1 gracza:
        try {
            g1.efektMojegoStrzalu(2, 0, g2.strzalOdPrzeciwnika(2, 0));
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

         if (g2.koniecGry() == true) {
             System.out.println("Koniec gry. Wygrał gracz 1.");
         }
        // 1 strzal 2 gracza
         try {
             g2.efektMojegoStrzalu(6, 6, g1.strzalOdPrzeciwnika(6, 6));
         } catch (InvalidOperationException e) {
             System.out.println(e.getMessage());
         }

         if (g1.koniecGry() == true) {
             System.out.println("Koniec gry. Wygrał gracz 2.");
         }


        g1.wyswietlPlanszeWroga();
        System.out.println();

        g2.wyswietlPlanszeWroga();


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
