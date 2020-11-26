package week04;

public class Product {

    private final int CONVERTPRICE = 300;

    private long price;
    private Currency currency;

    public Product(long price, Currency currency) {
       /*
        if (!"HUF".equals(currency) || !"USD".equals(currency)) {
            throw new IllegalArgumentException("Currency only HUF or USD!");
        }*/
        this.price = price;
        this.currency = currency;
    }

    public double convertPrice(Currency currency) {
        if (currency == Currency.HUF) {
           return price * CONVERTPRICE;
        }
        if (currency == Currency.USD) {
            return (double)price / CONVERTPRICE;
        }
        return 0.0;
    }

    /*private boolean isEmpty(String s) {
        if (s = null || s.isBlank()) {
            return true;
        }
        return false;
    }*/
}
