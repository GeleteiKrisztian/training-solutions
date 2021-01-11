package collectionslist;

import java.util.*;

public class Draw {
    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then "+ maxNumber + "!");
        }
        if (drawCount < 0 || maxNumber < 0) {
            throw new IllegalArgumentException("");
        }

        List<Integer> drawNumbers = new LinkedList<>();
        Random rnd = new Random();
        while (drawNumbers.size() != maxNumber) {
            int ball = rnd.nextInt(drawCount -1) + 1;
            drawNumbers.add(ball);
        }

        Queue<Integer> conv = new LinkedList<>(drawNumbers);
        TreeSet res = new TreeSet();
        for (int i = 0; i < drawCount; i++) {
            res.add(conv.poll());
        }
        return res;
    }

}
