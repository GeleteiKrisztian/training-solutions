package week06d01;

import java.util.ArrayList;
import java.util.List;

public class SumResults {

    private List<Double> negativeNumbers = new ArrayList<>();
    private List<Double> positiveNumbers = new ArrayList<>();
    private double posSum;
    private double negSum;

    public SumResults(List<Double> negativeNumbers, List<Double> positiveNumbers,double negSum,double posSum) {
        this.negativeNumbers = new ArrayList<>(negativeNumbers);
        this.positiveNumbers = new ArrayList<>(positiveNumbers);
        this.negSum = negSum;
        this.posSum = posSum;
    }

    public List<Double> getNegativeNumbers() {
        return negativeNumbers;
    }

    public List<Double> getPositiveNumbers() {
        return positiveNumbers;
    }

    public double getPosSum() {
        return posSum;
    }

    public double getNegSum() {
        return negSum;
    }
}
