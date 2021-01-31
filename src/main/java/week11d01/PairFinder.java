package week11d01;

import java.util.*;

public class PairFinder {

    private int pairsCounter;

    public int findPairs(int[] arr) {
        Map<Integer, Integer> numbersCounter = new HashMap<>();
        for (int item : arr) {
            if (numbersCounter.containsKey(item)) {
                numbersCounter.put(item, numbersCounter.get(item) + 1);
            } else {
                numbersCounter.put(item, 1);
            }
        }
        for (Integer value : numbersCounter.values()) {
            pairsCounter += value / 2;
        }
        return pairsCounter;
    }

}
