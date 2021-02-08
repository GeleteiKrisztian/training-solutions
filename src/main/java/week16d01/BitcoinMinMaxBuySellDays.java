package week16d01;

public class BitcoinMinMaxBuySellDays {

    private int min;
    private int max;

    public BitcoinMinMaxBuySellDays(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getBestBuyDay() {
        return min;
    }

    public int getBestSelDay() {
        return max;
    }
}
