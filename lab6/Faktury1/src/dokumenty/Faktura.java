package dokumenty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import magazyn.KategoriaTowaru;
import main.Konfiguracja;
import rabaty.ObliczCenePoRabacie;


public class Faktura {
	private Date dataSprzedazy;
	private String kontrahent;
	private ArrayList<Pozycja> pozycje;
	protected double suma;
	public Faktura(Date dataSprzedazy,String kontrahent)
	{
		this.dataSprzedazy=dataSprzedazy;
		this.kontrahent=kontrahent;
		pozycje=new ArrayList<Pozycja>();
		suma=0;
	}
	public void dodajPozycje(KategoriaTowaru towar, double ilosc)
	{
		ObliczCenePoRabacie obliczCenePoRabacie=Konfiguracja.getInstance().getObliczanieRabatu();
		if (obliczCenePoRabacie==null){
			throw new IllegalArgumentException("Sposób obliczania rabatu nie ustawiony");
		}
		double nowaCena= obliczCenePoRabacie.obliczCenePoRabacie(towar.getCena());
		Pozycja pozycja=new Pozycja(towar,ilosc);
		pozycja.setCena(nowaCena);
		pozycje.add(pozycja);

		this.przeliczSume();
	}
	public double getSuma()
	{
		return suma;
	}
	public Date getDataSprzedazy()
	{
		return dataSprzedazy;
	}

	//jak sie zmieni cos na fakturze to trzeba wywolac te metode
	private void przeliczSume()
	{
		Iterator<Pozycja> iteratorPozycji=pozycje.iterator();
		Pozycja pozycja;
		suma=0;
		while(iteratorPozycji.hasNext())
		{
			pozycja = iteratorPozycji.next();
			suma+=pozycja.getWartosc();
		}
	}
	public Iterator<Pozycja> getIteratorPozycji()
	{
		return pozycje.iterator();
	}
	public String getKontrahent()
	{
		return this.kontrahent;
	}


}
