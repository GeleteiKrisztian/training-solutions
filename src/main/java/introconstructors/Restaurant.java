package introconstructors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {

    private List<String> menu;
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = numberOfTables * 4;
    }

    public void setMenu(String[] menuArray) {
        menu = new ArrayList<>(Arrays.asList(menuArray));
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Chinie",10);
        restaurant.setMenu(new String[] {"Fish","Sushi","Sake"});
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Number of places available: " + restaurant.getCapacity());
        System.out.println("Menu: " + restaurant.getMenu());
    }
}
