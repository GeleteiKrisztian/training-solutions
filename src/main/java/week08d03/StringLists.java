package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> shortestWords(List<String> words) {
        List<String> result = new ArrayList<>();
        String word = null;
        for (String item : words) {
          if (word == null || item.length() < word.length()) {
              word = item;
          }
        }

        int wordLength = word.length();
        for (String item : words) {
            if (item.length() == wordLength) {
                result.add(item);
            }
        }
        return result;
    }

}
