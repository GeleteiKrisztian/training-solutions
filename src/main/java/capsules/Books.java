package capsules;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<String> title = new ArrayList<>();

    public void add(String title) {
        this.title.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> valogatas = new ArrayList<>();
        for (String item : title) {
            if( item.startsWith(prefix) ) {
                valogatas.add(item);
            }
        }
        return valogatas;
    }

    public List<String> getTitles() {
        return title;
    }

    public static void main(String[] args) {
        Books books = new Books();
        books.add("Hello World");
        books.add("Hell Energy Drink");
        books.add("Ezer élet");
        System.out.println(books.getTitles());

        System.out.println(books.findAllByPrefix("Hell"));
    }
}
