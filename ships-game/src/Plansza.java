public class Plansza {
    private final Character[][] zawartoscPlanszy;
    private final char[] dozwoloneZnaki;

    public Plansza(int iloscWierszy, int iloscKolumn, char[] dozwoloneZnaki) {
        zawartoscPlanszy = new Character[iloscWierszy][iloscKolumn];
        for (int i = 0; i < iloscWierszy; i++) {
            for (int j = 0; j < iloscKolumn; j++) {
                zawartoscPlanszy[i][j] = '.';
            }
        }
        this.dozwoloneZnaki = dozwoloneZnaki;
    }

    public void wyswietl() {
        /* for (Character[] row : zawartoscPlanszy) {
            for (Character pole : row) {

            }
        } */

        for (int i = 0; i < zawartoscPlanszy.length; i++) {
            for (int j = 0; j < zawartoscPlanszy[i].length; j++) {
                System.out.print(zawartoscPlanszy[i][j]);
            }
            System.out.println();
        }
    }

    public void ustawStatek(int numerWiersza, int numerKolumny, boolean czyPionowo, int dlugoscStatku) throws IndexOutOfBoundsException, InvalidOperationException {
        for (int i = numerWiersza; i < numerWiersza + dlugoscStatku; i++) {
            for (int j = numerKolumny; j < numerKolumny + dlugoscStatku; j++) {
                if (czyPionowo) {
                    if (zawartoscPlanszy[i][numerKolumny] == '@') {
                        throw new InvalidOperationException("Podano nieprawidłowe współrzędne. Statek nachodzi na inny.");
                    }
                } else {
                    if (zawartoscPlanszy[numerWiersza][j] == '@') {
                        throw new InvalidOperationException("Podano nieprawidłowe współrzędne. Statek nachodzi na inny.");
                    }
                }
            }
        }
        for (int i = numerWiersza; i < numerWiersza + dlugoscStatku; i++) {
            for (int j = numerKolumny; j < numerKolumny + dlugoscStatku; j++) {
                if (czyPionowo) {
                    zawartoscPlanszy[i][numerKolumny] = '@';
                } else {
                    zawartoscPlanszy[numerWiersza][j] = '@';
                }
            }
        }
    }

    public Character statusPola(int numerWiersza, int numerKolumny) throws IndexOutOfBoundsException {
        return zawartoscPlanszy[numerWiersza][numerKolumny];
    }

    public void ustawPole(int numerWiersza, int numerKolumny, Character znak) throws IndexOutOfBoundsException, WrongCharException {
        boolean czyZawiera = false;
        for (int i = 0; i < dozwoloneZnaki.length; i++) {
            if (znak == dozwoloneZnaki[i]) {
                czyZawiera = true;
            }
        }
        if (!czyZawiera) {
            throw new WrongCharException();
        }
        zawartoscPlanszy[numerWiersza][numerKolumny] = znak;
    }
    public boolean czyKoniecGry() {
        for (int i = 0; i < zawartoscPlanszy.length; i++) {
            for (int j = 0; j < zawartoscPlanszy[i].length; j++) {
                if (zawartoscPlanszy[i][j] == '@') {
                    return false;
                }
            }
        }
        return true;
    }
}
