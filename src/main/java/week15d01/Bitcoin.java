package week15d01;

import java.util.List;

public class Bitcoin {

    public BestBuyDays calculateBestBuySellDays(List<Integer> dollars) {
        BestBuyDays bestBuyDays = new BestBuyDays();
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;
        for (int i = 0; i < dollars.size(); i++) {
            int actualPrice = dollars.get(i);
            if (actualPrice < minPrice) {
               bestBuyDays.setBuyDay(i + 1);
               minPrice = actualPrice;
           }
           if (dollars.get(i) > maxPrice) {
               bestBuyDays.setSellDay(i + 1);
               maxPrice = actualPrice;
           }
        }
        return bestBuyDays;
    }
}
