package algorithmsmax;

import java.util.List;

public class IntegerMaxCalculator {

    public Integer max(List<Integer> ints) {
        Integer num = null;
        for (Integer item : ints) {
            if (num == null || item > num) {
                num = item;
            }
        }
        return num;
    }

}
