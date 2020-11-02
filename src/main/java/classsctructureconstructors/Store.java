package classsctructureconstructors;

public class Store {

    String product;
    int stock;

    public Store(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public int getStock() {
        return stock;
    }

    public void store(int addStock) {
        this.stock += addStock;
    }

    public void dispatch(int decrStock) {
        this.stock -= decrStock;
    }
}
