package controladvanced;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    private List<Integer> returnInts = new ArrayList<>();

    public void findDuplicates(List<Integer> ints) {
        for (int i = 0; i < ints.size(); i++) {
            for (int j = i + 1; j < ints.size() -1; j++) {
                boolean equals = ints.get(i).equals(ints.get(j));
                if (equals) {
                    returnInts.add(ints.get(j));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Duplicates duplicates = new Duplicates();
        for (int i = 0; i < 20; i += 2) {
            ints.add(Integer.valueOf(i));
        }
        for (int j = 0; j < 30; j += 3) {
            ints.add(Integer.valueOf(j));
        }
        System.out.println(ints);
        duplicates.findDuplicates(ints);
        System.out.println(duplicates.returnInts);

    }
}
