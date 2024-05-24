package magazyn;

import java.util.ArrayList;
import java.util.List;

public class PodkategoriaTowaru implements ITowar{
    private List<ITowar> towary;
    private final String nazwa;
    public PodkategoriaTowaru(String nazwa,List<ITowar> towary){
        this.towary=towary;
        this.nazwa=nazwa;
    }

    public void add(ITowar towar){
        towary.add(towar);
    }
    @Override
    public double getCena() {
        double cena=0;
        for(ITowar towar:towary){
            cena+=towar.getCena();
        }
        return cena;
    }

    @Override
    public void wypisz(int n) {
        System.out.println("    ".repeat(n)+"Podkategoria: "+nazwa+", zawiera: ");
        for(ITowar towar:towary){
            towar.wypisz(n+1);
        }
        System.out.println("    ".repeat(n)+"Sumaryczna cena: "+getCena());
    }
}
