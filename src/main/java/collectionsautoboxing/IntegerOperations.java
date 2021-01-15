package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers) {
        List<Integer> ints = new ArrayList<>();
        for (int item : numbers) {
            ints.add(item);
        }
        return ints;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int sum = 0;
        for (int item : integerList) {
            sum += item;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers) {
        int sum = 0;
        for (int item : integers) {
            sum += item;
        }
        return sum;
    }

}
