public class Gracz {

    private Plansza planszaWlasna;
    private Plansza planszaWroga;
    private final char[] dozwoloneZnaki = {'.', '@', 'X', '*'};

    public Gracz(int iloscWierszy, int iloscKolumn) {
        planszaWlasna = new Plansza(iloscWierszy, iloscKolumn, dozwoloneZnaki);
        planszaWroga = new Plansza(iloscWierszy, iloscKolumn, dozwoloneZnaki);
    }

    public void ustawStatek(int numerWiersza, int numerKolumny, boolean czyPionowo, int dlugoscStatku) throws InvalidOperationException {
        try {
            planszaWlasna.ustawStatek(numerWiersza,numerKolumny,czyPionowo,dlugoscStatku);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidOperationException("Podano nieprawidłlowe współrzędne. Statek poza planszą.", e);
        }

    }

    public void wystwietlWlasnaPlansze() {
        planszaWlasna.wyswietl();
    }

    public void wyswietlPlanszeWroga() {
        planszaWroga.wyswietl();
    }

    public String strzalOdPrzeciwnika(int numerWiersza, int numerKolumny) throws InvalidOperationException {
        try {
            Character znak = planszaWlasna.statusPola(numerWiersza,numerKolumny);
            if (znak == '@') {
                planszaWlasna.ustawPole(numerWiersza, numerKolumny,'X');
                return "trafiony";
            } else {
                return "pudlo" ;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidOperationException("Podano nieprawidłlowe współrzędne.", e);
        } catch (WrongCharException e) {
            throw new InvalidOperationException("Podano nieprawidłlowy znak.", e);
        }
    }

    public void efektMojegoStrzalu (int numerWiersza, int numerKolumny, String rezultat) throws InvalidOperationException {
        try {
            if ("trafiony".equals(rezultat)) {
                planszaWroga.ustawPole(numerWiersza, numerKolumny,'X');
            } else {
                planszaWroga.ustawPole(numerWiersza, numerKolumny,'*');
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidOperationException("Podano nieprawidłlowe współrzędne.", e);
        } catch (WrongCharException e) {
            throw new InvalidOperationException("Podano nieprawidłlowy znak.", e);
        }
    }

    public boolean koniecGry() {
       return planszaWlasna.czyKoniecGry();
    }
}
