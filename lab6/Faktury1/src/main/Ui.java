package main;

import java.util.Calendar;
import java.util.List;

import magazyn.KategoriaTowaru;
import magazyn.PodkategoriaTowaru;
import wydruki.WydrukFaktury;
import dokumenty.Faktura;

//ZEWNETRZNY RABAT
import rabatlosowy.LosowyRabat;
import rabaty.AdapterLosowegoRabatu;
import rabaty.ObliczCenePoRabacieKwotowym;
import rabaty.ObliczCenePoRabacieProcentowym;
import wydruki.WydrukSkrocony;
import wydruki.WydrukStandardowy;


public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();

		//Tworzymy towary
		KategoriaTowaru t1=new KategoriaTowaru(10,"buty");
		KategoriaTowaru t2=new KategoriaTowaru(2,"skarpety");
		KategoriaTowaru t3=new KategoriaTowaru(5,"spodnie");


		PodkategoriaTowaru pk1=new PodkategoriaTowaru("Pudełko", List.of(t1,t2));
		PodkategoriaTowaru pk2=new PodkategoriaTowaru("Reklamówka", List.of(pk1,t3));
		PodkategoriaTowaru pk3=new PodkategoriaTowaru("Plecak",List.of(pk1,pk2));

		pk3.wypisz(0);

//		Konfiguracja.getInstance().setObliczanieRabatu(new ObliczCenePoRabacieProcentowym(0.9));
//		Konfiguracja.getInstance().setWydruk(new WydrukStandardowy());
//
//
//		//I przykladowa fakture
//		Faktura f=new Faktura(teraz.getTime(),"Fido");
//		f.dodajPozycje(t1,3);
//		f.dodajPozycje(t2, 5);
//
//		System.out.println("Rabat procentowy:");
//		WydrukFaktury.drukujFakture(f);
//
//		Konfiguracja.getInstance().setObliczanieRabatu(new ObliczCenePoRabacieKwotowym(1.5));
//
//
//		f=new Faktura(teraz.getTime(),"Fido");
//		f.dodajPozycje(t1,3);
//		f.dodajPozycje(t2, 5);
//
//		System.out.println("Rabat kwotowy:");
//		WydrukFaktury.drukujFakture(f);
//
//		Konfiguracja.getInstance().setObliczanieRabatu(new ObliczCenePoRabacieKwotowym(0));
//		Konfiguracja.getInstance().setWydruk(new WydrukSkrocony());
//
//		f=new Faktura(teraz.getTime(),"Fido");
//		f.dodajPozycje(t1,3);
//		f.dodajPozycje(t2, 5);
//
//		System.out.println("Przed rabatem:");
//		WydrukFaktury.drukujFakture(f);
//
//		//TEST ZEWN. rabatu
//		LosowyRabat lr=new LosowyRabat();
//
//		Konfiguracja.getInstance().setObliczanieRabatu(new AdapterLosowegoRabatu(lr));
//
//
//		f=new Faktura(teraz.getTime(),"Fido");
//		f.dodajPozycje(t1,3);
//		f.dodajPozycje(t2, 5);
//
//		System.out.println("Rabat losowy:");
//		WydrukFaktury.drukujFakture(f);
	}


}
