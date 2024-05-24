package magazyn;

public class KategoriaTowaru implements ITowar{
	private double cena;
	private String nazwa;
	
	public KategoriaTowaru(double cena, String nazwa)
	{
		this.cena=cena;
		this.nazwa=nazwa;
	}
	
	//operacje na cenie
	public void setCena(double cena)
	{
		this.cena=cena;
	}
	@Override
	public double getCena()
	{
		return cena;
	}

	@Override
	public void wypisz(int n) {
		String space="	".repeat(n);
		System.out.println(space+"Kategoria towaru: Nazwa: "+nazwa+", Cena: "+cena);
	}

	//operacje na nazwie towaru
	public String getNazwa()
	{
		return nazwa;
	}
	public void setNazwa(String nazwa)
	{
		this.nazwa=nazwa;
	}
}
