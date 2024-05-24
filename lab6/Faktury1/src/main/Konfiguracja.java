package main;

import rabaty.ObliczCenePoRabacie;
import wydruki.WydrukTemplate;

public class Konfiguracja {

    private static Konfiguracja instance;
    private ObliczCenePoRabacie obliczanieRabatu;
    private WydrukTemplate wydruk;

    private Konfiguracja(ObliczCenePoRabacie obliczanieRabatu, WydrukTemplate wydruk){
        this.obliczanieRabatu=obliczanieRabatu;
        this.wydruk=wydruk;
    }

    private Konfiguracja(){
    }

    public static Konfiguracja getInstance(ObliczCenePoRabacie obliczanieRabatu, WydrukTemplate wydruk){
        if(instance==null){
            instance=new Konfiguracja(obliczanieRabatu,wydruk);
        }
        return instance;
    }

    public static Konfiguracja getInstance(){
        if(instance==null){
            instance=new Konfiguracja();
        }
        return instance;
    }

    public void setObliczanieRabatu(ObliczCenePoRabacie obliczanieRabatu) {
        this.obliczanieRabatu = obliczanieRabatu;
    }

    public ObliczCenePoRabacie getObliczanieRabatu(){
        return obliczanieRabatu;
    }

    public WydrukTemplate getWydruk() {
        return wydruk;
    }

    public void setWydruk(WydrukTemplate wydruk) {
        this.wydruk = wydruk;
    }
}
