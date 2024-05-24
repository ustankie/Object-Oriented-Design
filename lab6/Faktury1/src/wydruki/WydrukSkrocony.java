package wydruki;

import dokumenty.Faktura;
import dokumenty.Pozycja;

import java.util.Iterator;

public class WydrukSkrocony extends WydrukTemplate{
    @Override
    public void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("Faktura");
    }

    @Override
    public void drukujStopke(Faktura faktura) {
        System.out.println("Suma skrocona: "+faktura.getSuma());
        System.out.println("=====================================================");
    }

    @Override
    public void drukujPozycje(Faktura faktura){
        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Wartosc:" + pozycja.getWartosc());
        }
    }
}
