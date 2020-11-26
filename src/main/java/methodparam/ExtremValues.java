package methodparam;

public class ExtremValues {

    private double minValue;
    private double maxValue;

    public ExtremValues(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public double getMin() {
        return minValue;
    }

    public double getMax() {
        return maxValue;
    }

}
