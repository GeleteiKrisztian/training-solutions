package classsctructureconstructors;

public class StoreMain {

    public static void main(String[] args) {
        Store store = new Store("Samsung");
        Store store2 = new Store("Iphone");

        store.store(250);
        store2.store(500);

        System.out.println(store.getProduct() + ": " + store.getStock());
        System.out.println(store2.getProduct() + ": " + store2.getStock());

        store.dispatch(51);
        store2.dispatch(1);

        System.out.println(store.getProduct() + ": " + store.getStock());
        System.out.println(store2.getProduct() + ": " + store2.getStock());

    }
}
