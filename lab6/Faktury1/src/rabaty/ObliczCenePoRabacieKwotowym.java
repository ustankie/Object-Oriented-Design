package rabaty;

import static java.lang.Math.max;

public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie{

    private double kwotaRabatu;
    public ObliczCenePoRabacieKwotowym(double kwotaRabatu){
        this.kwotaRabatu=kwotaRabatu;
    }
    @Override
    public double obliczCenePoRabacie(double cena) {
        return max(cena-kwotaRabatu,0);
    }

    public double getKwotaRabatu() {
        return kwotaRabatu;
    }

    public void setKwotaRabatu(double kwotaRabatu) {
        this.kwotaRabatu = kwotaRabatu;
    }


}
