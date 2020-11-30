package staticattrmeth;

import java.math.BigDecimal;

public class BankTransaction {

    private long trxValue;

    private static final long MIN = 1;
    private static final long MAX = 10_000_000;

    private static BigDecimal transactionsCounter = new BigDecimal(0);
    private static BigDecimal transactionsSum = new BigDecimal(0);

    private static long currentMinValue = Long.MAX_VALUE; //A getter metódusa 0-t ad vissza,ha Long.MAX_VALUE
    private static long currentMaxValue = 0;

    public static void initTheDay() {
        transactionsCounter = new BigDecimal(0);
        transactionsSum = new BigDecimal(0);
        currentMinValue = Long.MAX_VALUE;
        currentMaxValue = 0;
    }

    public static BigDecimal averageOfTransaction() {
        if (transactionsCounter == BigDecimal.ZERO) {
            return BigDecimal.ZERO;
        }
        return transactionsSum.divide(transactionsCounter);
    }

    public static long getCurrentMinValue() {
        if (currentMinValue == Long.MAX_VALUE) {
            return 0;
        }
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return transactionsSum;
    }

    public BankTransaction(long trxValue) {
        if (trxValue < MIN || trxValue > MAX) {
            throw new IllegalArgumentException("Value is not in range!");
        }
        if (trxValue > currentMaxValue) {
            currentMaxValue = trxValue;
        }
        if (trxValue > 0 && trxValue < currentMinValue) {
            currentMinValue = trxValue;
        }
        transactionsCounter = transactionsCounter.add(BigDecimal.valueOf(1));
        transactionsSum = transactionsSum.add(BigDecimal.valueOf(trxValue));
        this.trxValue = trxValue;
    }

}
