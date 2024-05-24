package wydruki;

import dokumenty.Faktura;
import dokumenty.Pozycja;
import main.Konfiguracja;

import java.util.Iterator;

public class WydrukFaktury {

    public static void drukujFakture(Faktura faktura){
        Konfiguracja.getInstance().getWydruk().drukujNaglowek(faktura);
        Konfiguracja.getInstance().getWydruk().drukujPozycje(faktura);
        Konfiguracja.getInstance().getWydruk().drukujStopke(faktura);
    }

}
