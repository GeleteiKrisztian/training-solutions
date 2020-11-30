package week06d01;

import java.util.ArrayList;
import java.util.List;

public class SeparatedSum {

    public SumResults sumString(String s) {
        isNullOrEmpty(s);
        String res = s.replace(',','.');
        String[] split = res.split(";");
        //Scanner scanner = new Scanner(s).delimiter(";");
        List<Double> negatives = new ArrayList<>();
        List<Double> positives = new ArrayList<>();
        for (String item : split) {
            double d = Double.valueOf(item);
            if (d < 0) {
                negatives.add(d);
            }
            else {
                positives.add(d);
            }
        }
        return new SumResults(negatives,positives,negToSum(negatives),posToSum(positives));
    }

    private void isNullOrEmpty(String s) {
        if (s==null || s.isBlank()) {
            throw new IllegalArgumentException("Argument is null or empty!");
        }
    }

    private double posToSum(List<Double> posNums) {
        double sum = 0;
        for (double item : posNums) {
            sum += item;
        }
        return sum;
    }

    private double negToSum(List<Double> negNums) {
        double sum = 0;
        for (double item : negNums) {
            sum += item;
        }
        return sum;
    }

}
