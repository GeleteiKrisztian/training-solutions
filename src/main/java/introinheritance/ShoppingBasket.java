package introinheritance;

public class ShoppingBasket {

    private Basket basket = new Basket();


    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getNettoPrice() + item.getTaxAmount();
        }
        return sum;
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        Item mostExpensive = null;
        for (Item item : basket.getItems()) {
            if (mostExpensive == null || (mostExpensive.getNettoPrice() < item.getNettoPrice())) {
                mostExpensive = item;
            }
        }
        basket.removeItem(mostExpensive.getBarcode());
    }

    public Basket getBasket() {
        return basket;
    }
}
