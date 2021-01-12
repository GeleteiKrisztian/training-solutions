package collectionsset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings) {
        Set<String> uniqueWords = new TreeSet<>();
        for (String item : randomStrings) {
            uniqueWords.add(item);
        }
        return uniqueWords;
    }

}
