package week11d04;

import java.util.*;

public class NumberLength {

    public List<Integer> getLengths(List<String> names) {
        Set<Integer> lengths = new HashSet<>();
        for (String item : names) {
            if (item.startsWith("J")) {
                lengths.add(item.length());
            }
        }
        List<Integer> result = new ArrayList<>(lengths);
        return result;
    }

}
