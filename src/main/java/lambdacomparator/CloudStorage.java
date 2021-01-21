package lambdacomparator;

public class CloudStorage implements Comparable<CloudStorage> {

    private String provider;
    private int storage;
    private PayPeriod period;
    private double price;

    public CloudStorage(String provider, int storage, PayPeriod period, double price) {
        this.provider = provider;
        this.storage = storage;
        this.period = period;
        this.price = price;
    }

    public CloudStorage(String provider, int storage) {
        this.provider = provider;
        this.storage = storage;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return storage;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    private double yearlyPriceCalculator(CloudStorage cloudStorage) {
        double yearlyPrice = 0;
        if (storage < 1000) {
            double num = 1000d / storage;
            yearlyPrice = num * price;
        } else {
            double num = storage / 1000d;
            yearlyPrice = price / num;
        }

        if (period == PayPeriod.MONTHLY) {
            yearlyPrice *= period.getLength();
            //ha ANNUAL,akkor marad az eredeti ár,ha pedig nem MONTHLY,akkor már nem vizsgálom,csak egy else ágat használok
        } else {
            yearlyPrice /= 5;
        }
        return yearlyPrice;
    }

    @Override
    public int compareTo(CloudStorage o) {
        return Double.compare(yearlyPriceCalculator(this), yearlyPriceCalculator(o));
    }
}
