package week06d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItem(String name, int quantity) {
        Item item = new Item(name, quantity);
        int i = isItemExist(item);
        if (i != -1) {
            items.get(i).setQuantity(items.get(i).getQuantity() + quantity);
        } else {
            items.add(item);
        }
    }

    public int getItem(String name) {
        for (Item item : items) {
            if(item.getName().equals(name)) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    // -1 ad vissza,ha nincs benne,kül az indexét
    private int isItemExist(Item itemToCheck) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(itemToCheck.getName())) {
                return i;
            }
        }
        return -1;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

}
