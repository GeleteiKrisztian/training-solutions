package week10d05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static final int ITERATION = 4;
    private int min;
    private int max;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void findMinMaxSum(Integer[] arr) {
        List<Integer> nums = Arrays.asList(arr);
        nums.sort(Comparator.naturalOrder());

        for (int i = 0; i < ITERATION; i++) {
            min += nums.get(i);
        }
        for (int i = nums.size() - 1; i > (nums.size() - 1) - ITERATION; i--) {
            max += nums.get(i);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Add meg hány számot szeretnél megadni: ");
        int inpNums = scan.nextInt();
        Integer[] arr = new Integer[inpNums];
        for (int i = 0; i < inpNums; i++) {
            System.out.println("A(z) " + (i + 1) + ". szám: ");
            arr[i] = scan.nextInt();
        }
        Calculator calc = new Calculator();
        calc.findMinMaxSum(arr);
        System.out.println(calc.min);
        System.out.println(calc.max);
    }

}
