package week06d02;

public enum Categories {

    FROZEN, DAIRY, BAKEDGOODS, OTHER;

    private int quantity = 0;

    public void incQuantity() {
        this.quantity += 1;
    }

    public int getQuantity() {
        return quantity;
    }
}
