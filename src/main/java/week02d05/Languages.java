package week02d05;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {
        List<String> langNames = new ArrayList<>();
        langNames.add("Java");
        langNames.add("C++");
        langNames.add("C#");
        langNames.add("Python");

        for (String item : langNames) {
            if (item.length() > 5) {
                System.out.println(item);
            }
        }
    }
}
