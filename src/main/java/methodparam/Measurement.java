package methodparam;

public class Measurement {

    private double[] measureResults;

    public Measurement(double[] measureResults) {
        double[] values = new double[measureResults.length];
        for (int i = 0;i < measureResults.length; i++) {
            values[i] = measureResults[i];
        }
        this.measureResults = values;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0;i < measureResults.length; i++) {
            if ((measureResults[i] > (double) lower) && (measureResults[i] < (double) upper)) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double res = Double.MAX_VALUE;
        for (double item : measureResults) {
            if (item < res) {
                res = item;
            }
        }
        if (res == Double.MAX_VALUE) {
            throw new IllegalStateException("Not found");
        }
        return res;
    }

    public double maximum() {
        double res = 0.0;
        for (double item : measureResults) {
            if (item > res) {
                res = item;
            }
        }
        if (res == Double.MAX_VALUE) {
            throw new IllegalStateException("Not found");
        }
        return res;
    }

    public ExtremValues minmax() {
        double min = minimum();
        double max = maximum();
        return new ExtremValues(min,max);
    }

}
