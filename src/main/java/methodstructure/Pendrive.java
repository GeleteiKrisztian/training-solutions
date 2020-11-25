package methodstructure;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public void risePrice(int percent) {
        price += (int) (price * (percent / 100.0));
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        if (priceCapacityCalulator(price,capacity) > priceCapacityCalulator(pendrive.getPrice(),pendrive.getCapacity())) {
            return 1;
        } else if (priceCapacityCalulator(price,capacity) < priceCapacityCalulator(pendrive.getPrice(),pendrive.getCapacity())) {
            return -1;
        } else
            return 0;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        if (price < pendrive.getPrice()) {
            return true;
        }
        else
            return false;
    }

    public double priceCapacityCalulator(int price, int capacity) {
        return price / (double) capacity;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
