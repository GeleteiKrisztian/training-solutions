package exam03;

public enum CruiseClass {
    LUXURY(3), FIRST(1.8), SECOND(1);

    private double priceRate;

    CruiseClass(double priceRate) {
        this.priceRate = priceRate;
    }

    public double getPriceRate() {
        return priceRate;
    }
}
