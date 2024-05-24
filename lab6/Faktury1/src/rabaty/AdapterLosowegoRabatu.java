package rabaty;

import rabatlosowy.LosowyRabat;

public class AdapterLosowegoRabatu extends ObliczCenePoRabacieProcentowym{
    private LosowyRabat losowyRabat;

    public AdapterLosowegoRabatu(LosowyRabat losowyRabat){
        super(1-losowyRabat.losujRabat());
        this.losowyRabat=losowyRabat;
    }

    @Override
    public double getProcentRabatu() {
        double nowyRabat=1-losowyRabat.losujRabat();

        super.setProcentRabatu(nowyRabat);
        return nowyRabat;
    }

    @Override
    public double obliczCenePoRabacie(double cena) {
        double nowyRabat=1-losowyRabat.losujRabat();
        super.setProcentRabatu(nowyRabat);

        return super.obliczCenePoRabacie(cena);
    }
}
