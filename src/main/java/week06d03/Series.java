package week06d03;

import java.util.List;

public class Series {

    public ListType calculateSeriesType(List<Integer> numbers) {
        if (isAsc(numbers)) {
            return ListType.ASCENDING;
        } else if (isDesc(numbers)) {
            return ListType.DESCENDING;
        } else
            return ListType.RANDOM;
    }

    private boolean isAsc(List<Integer> numbers) {
        isNullOrEmptyList(numbers);
        int firstNum = Integer.MIN_VALUE;
        for (Integer item : numbers) {
            if (item > firstNum) {
                firstNum = item;
            }
            else {
                return false;
            }
        }
        return true;
    }

    private boolean isDesc(List<Integer> numbers) {
        isNullOrEmptyList(numbers);
        int firstNum = Integer.MAX_VALUE;
        for (Integer item : numbers) {
            if (item < firstNum) {
                firstNum = item;
            }
            else {
                return false;
            }
        }
        return true;
    }

    private boolean isNullOrEmptyList(List<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("List can't be null or size less than 2!");
        }
        return false;
    }

}
