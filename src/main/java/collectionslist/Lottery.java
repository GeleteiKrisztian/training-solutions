package collectionslist;

import java.util.*;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {

        if (ballCount <= lotteryType) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        if (lotteryType < 0 || ballCount < 0) {
            throw new IllegalArgumentException("");
        }

        Set<Integer> winningNumbers = new HashSet<>();
        Random rnd = new Random();
        while (winningNumbers.size() != lotteryType) {
            int ball = rnd.nextInt(ballCount -1) + 1;
            winningNumbers.add(ball);
        }
        List<Integer> conv = new ArrayList<>(winningNumbers);
        Collections.sort(conv);
        return conv;
    }

}
