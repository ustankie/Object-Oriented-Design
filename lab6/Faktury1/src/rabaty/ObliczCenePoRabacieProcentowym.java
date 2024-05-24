package rabaty;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie{
    private double procentRabatu;
    public ObliczCenePoRabacieProcentowym(double procentRabatu){
        this.procentRabatu=procentRabatu;
    }
    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena*procentRabatu;
    }

    public double getProcentRabatu() {
        return procentRabatu;
    }

    public void setProcentRabatu(double procentRabatu) {
        if(procentRabatu<0 || procentRabatu>1){
            throw new IllegalArgumentException("Procent rabatu musi być pomiędzy 0 a 1");
        }
        this.procentRabatu = procentRabatu;
    }
}
