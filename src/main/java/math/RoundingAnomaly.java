package math;

import java.util.Random;

public class RoundingAnomaly {

    public double[] randomNumbers(int size, double max, int scale) {

        double[] arrayOfDoubles = new double[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            double mathPowResult = Math.pow(10,max);
            double precisionFix = mathPowResult * (rand.nextDouble() + rand.nextInt(scale));
            arrayOfDoubles[i] = Math.round(precisionFix) / mathPowResult;
        }
        return arrayOfDoubles;
    }

    public double roundAfterSum(double[] numbers) {
        double total = 0;

        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        double roundedTotal = Math.round(total);
        return roundedTotal;
    }

    public double sumAfterRound(double[] numbers) {
        double total = 0;

        for (int i = 0; i < numbers.length; i++) {
            total += Math.round(numbers[i]);
        }
        return total;
    }

    public double difference(int size, double max, int scale) {
        double[] arr = randomNumbers(size, max, scale);
        return roundAfterSum(arr) - sumAfterRound(arr);
    }

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        double total =0;
        for (int i = 0; i < 100; i++) {
            total += roundingAnomaly.difference(1000,5,1000000);
        }
        System.out.println("A 100 kerektési átlag: " + total / 100);
    }
}
