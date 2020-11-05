package finalmodifier.finalmodifier;

public class TaxCalculator {

    public final double AFA = 0.27;

    public double tax(double price) {
        return price * AFA;
    }

    public double priceWithTax(double price) {
        double afa = price * AFA;
        return price + afa;
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println("20 000 Ft ÁFA-ja: " + taxCalculator.tax(20000));
        System.out.println("100 000 Ft + ÁFA: " + taxCalculator.priceWithTax(100000));
    }
}
