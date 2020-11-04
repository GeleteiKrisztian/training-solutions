package capsules;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    private List<String> color = new ArrayList<>();

    public void addLast(String color) {
        this.color.add(color);
    }

    public void addFirst(String color) {
        this.color.add(0,color);
    }

    public void removeFirst() {
        color.remove(0);
    }

    public void removeLast() {
        color.remove(this.color.size()-1);
    }

    public List<String> getColors() {
        return color;
    }

    public static void main(String[] args) {

        Capsules caps = new Capsules();
        caps.addLast("Kék");
        caps.addFirst("Zöld");
        System.out.println(caps.getColors());

        caps.removeFirst();
        System.out.println(caps.getColors());

        caps.addLast("Piros");
        caps.addLast("Fekete");
        caps.removeLast();
        System.out.println(caps.getColors());

        List<String> save = new ArrayList<>();
        save = caps.getColors();
        save.clear();
        System.out.println(caps.getColors());

    }
}
