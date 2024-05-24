package wydruki;

import dokumenty.Faktura;

public class WydrukStandardowy extends WydrukTemplate{
    @Override
    public void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("FA z dnia: "+faktura.getDataSprzedazy().toString());
        System.out.println("Wystawiona dla: "+faktura.getKontrahent());
    }

    @Override
    public void drukujStopke(Faktura faktura) {
        System.out.println("Suma: "+faktura.getSuma());
        System.out.println("=====================================================");
    }
}
