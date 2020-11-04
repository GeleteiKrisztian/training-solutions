package introcontrol;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg 5 számot:");
        int total = 0;

        for (int i = 0;i < 5;i++) {
            int inpNum = scanner.nextInt();
            total += inpNum;
        }
        System.out.println(total);
    }
}
