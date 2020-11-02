package statements;

import java.util.Scanner;

public class DivByThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg egy egész számot megvizsgálni,hogy osztható-e 3-mal: ");
        int inp = scanner.nextInt();
        boolean oszthato = (inp % 3 == 0);
        System.out.println("Az adott szám " + (oszthato ? "osztható" : "nem osztható") + " 3-mal.");
    }
}
