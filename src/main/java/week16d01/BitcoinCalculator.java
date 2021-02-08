package week16d01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BitcoinCalculator {

    private List<Bitcoin> bitcoins;

    public BitcoinCalculator(List<Bitcoin> bitcoinsParam) {
        List<Bitcoin> bitcoins = new ArrayList<>(bitcoinsParam);
        bitcoins.sort(Comparator.comparing(Bitcoin::getDateTime));
        this.bitcoins = bitcoins;
    }

    public BitcoinMinMaxBuySellDays minMaxDays() {
        int maxProfit = 0;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < bitcoins.size() - 1; i++) {
            for (int j = i + 1; j < bitcoins.size(); j++) {
                int max = bitcoins.get(j).getPrice() - bitcoins.get(i).getPrice();
                if (max > maxProfit) {
                    maxProfit = max;
                    minIndex = i;
                    maxIndex = j;
                }
            }
        }
        return new BitcoinMinMaxBuySellDays(minIndex + 1, maxIndex + 1);
    }

}
